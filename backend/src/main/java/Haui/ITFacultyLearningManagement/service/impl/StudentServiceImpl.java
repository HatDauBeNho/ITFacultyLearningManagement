package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.student.request.CreateStudentRequest;
import Haui.ITFacultyLearningManagement.custom.student.response.StudentReponse;
import Haui.ITFacultyLearningManagement.entities.Account;
import Haui.ITFacultyLearningManagement.entities.Classroom;
import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Student;
import Haui.ITFacultyLearningManagement.repository.AccountRepository;
import Haui.ITFacultyLearningManagement.repository.ClassroomRepository;
import Haui.ITFacultyLearningManagement.repository.InfoRepository;
import Haui.ITFacultyLearningManagement.repository.StudentRepository;
import Haui.ITFacultyLearningManagement.service.AccountService;
import Haui.ITFacultyLearningManagement.service.StudentService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.text.Normalizer;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private AccountRepository accountRepository;
    @Autowired
    private AccountService accountService;
    @Autowired
    private ClassroomRepository classroomRepository;

    @Override
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> findById(Integer id) {
        return studentRepository.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(Integer id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Optional<Student> findByName(String name) {
        return studentRepository.findByName(name);
    }

    @Override
    public Optional<Info> getStudentInfor(int id) {
        return studentRepository.getStudentInfor(id);
    }
    public static String removeAccents(String input)
    {
        String normalized= Normalizer.normalize(input,Normalizer.Form.NFD);
        Pattern pattern=Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
        return pattern.matcher(normalized).replaceAll("");
    }
    @Override
    public Student createStudentAccount(CreateStudentRequest request) {
        Account account=new Account();
        account.setRole("3");
        account.setUserName(removeAccents(request.getFullName()).toLowerCase().replace(" ","")+"@Haui");
        account.setPassword(accountService.randomPassword());
        account.setCreateTime(LocalDateTime.now());
        account.setUpdateTime(LocalDateTime.now());

        Info info =new Info();
        info.setAddress(request.getAddress());
        info.setEmail(request.getEmail());
        info.setGender(request.getGender());
        info.setEmail(request.getEmail());
        info.setDateOfBirth(request.getDateOfBirth());
        info.setPhoneNumber(request.getPhoneNumber());
        info.setFullName(request.getFullName());
        info.setCreateTime(LocalDateTime.now());
        info.setUpdateTime(LocalDateTime.now());

        Student student=new Student();
        student.setId(accountRepository.save(account).getId());
        student.setClassID(classroomRepository.findByName(request.getClassName()).get().getId());
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        student.setInfoID(infoRepository.save(info).getId());

        accountRepository.save(account);
        infoRepository.save(info);
        return  studentRepository.save(student);
    }

    @Override
    public List<StudentReponse> findAllForView() {
        List<StudentReponse> list=new ArrayList<>();
        for (Student item: studentRepository.findAll())
        {
            Info info =studentRepository.getStudentInfor(item.getId()).get();
            StudentReponse studentReponse=new StudentReponse(
                    info.getFullName(),
                    info.getDateOfBirth(),
                    info.getGender(),
                    info.getAddress(),
                    info.getPhoneNumber(),
                    info.getEmail(),
                    item.getGpa(),
                    classroomRepository.findById(item.getId()).get().getClassName()
            );
            list.add(studentReponse);
        }
        return list;
    }

    @Override
    public long countStudent() {
        return studentRepository.count();
    }

    @Override
    public List<Student> saveStudentFromExcel(InputStream inputStream) throws Exception {
        List<Student> studentList=new ArrayList<>();
        Workbook workbook=new XSSFWorkbook(inputStream);
        Sheet sheet=workbook.getSheetAt(0);
        for (Row row:sheet)
        {
            if (row.getRowNum()==0) continue;

            CreateStudentRequest createStudentRequest=new CreateStudentRequest(
                    row.getCell(0).getStringCellValue(),
                    row.getCell(1).getLocalDateTimeCellValue().toLocalDate(),
                    (int)row.getCell(2).getNumericCellValue(),
                    row.getCell(3).getStringCellValue(),
                    row.getCell(4).getStringCellValue(),
                    row.getCell(5).getStringCellValue(),
                    row.getCell(6).getStringCellValue()
            );
            System.out.println(createStudentRequest);
            Optional<Student> studentOptional=studentRepository.findByName(createStudentRequest.getFullName());
            Optional<Info> inforOptional= infoRepository.findByPhoneNumber(createStudentRequest.getPhoneNumber());
            Optional<Classroom> classroomOptional= classroomRepository.findByName(createStudentRequest.getClassName());
            if (studentOptional.isPresent()||inforOptional.isPresent()||classroomOptional.isEmpty()) continue;
            studentList.add(createStudentAccount(createStudentRequest));
        }
        workbook.close();
        return  studentList;
    }

}
