//package Haui.ITFacultyLearningManagement.service.impl;
//
//
//import Haui.ITFacultyLearningManagement.custom.teacher.request.CreateTeacherRequest;
//import Haui.ITFacultyLearningManagement.custom.teacher.response.TeacherResponse;
//import Haui.ITFacultyLearningManagement.entities.Account;
//import Haui.ITFacultyLearningManagement.entities.Info;
//import Haui.ITFacultyLearningManagement.entities.Teacher;
//import Haui.ITFacultyLearningManagement.repository.AccountRepository;
//import Haui.ITFacultyLearningManagement.repository.InforRepository;
//import Haui.ITFacultyLearningManagement.repository.TeacherRepository;
//import Haui.ITFacultyLearningManagement.service.AccountService;
//import Haui.ITFacultyLearningManagement.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.time.LocalDateTime;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class TeacherServiceImpl implements TeacherService {
//
//    @Autowired
//    private TeacherRepository teacherRepository;
//    @Autowired
//    private AccountRepository accountRepository;
//    @Autowired
//    private AccountService accountService;
//    @Autowired
//    private InforRepository inforRepository;
//
//
//    @Override
//    public List<Teacher> findAll() {
//        return teacherRepository.findAll();
//    }
//
//    @Override
//    public Optional<Teacher> findById(Integer id) {
//        return teacherRepository.findById(id);
//    }
//
//    @Override
//    public Teacher save(Teacher teacher) {
//        return teacherRepository.save(teacher);
//    }
//
//    @Override
//    public void deleteById(Integer id) {
//        teacherRepository.deleteById(id);
//    }
//
//    @Override
//    public Optional<Teacher> findByName(String name) {
//        return teacherRepository.findByName(name);
//    }
//
//    @Override
//    public Optional<Info> getTeacherInfor(int id) {
//        return teacherRepository.getTeacherInfor(id);
//    }
//
//    @Override
//    public void createTeacherAccount(CreateTeacherRequest request) {
//        Account account=new Account();
//        account.setRole("2");
//        account.setUserName(request.getFullName().toLowerCase().replace(" ","")+"@Haui");
//        account.setPassword(accountService.randomPassword());
//        account.setCreateAt(LocalDateTime.now());
//        account.setUpdatedAt(LocalDateTime.now());
//
//        Info info =new Info();
//        info.setAddress(request.getAddress());
//        info.setEmail(request.getEmail());
//        info.setGender(request.getGender());
//        info.setEmail(request.getEmail());
//        info.setDateOfBirth(request.getDateOfBirth());
//        info.setPhoneNumber(request.getPhoneNumber());
//        info.setFullName(request.getFullName());
//        info.setCreateAt(LocalDateTime.now());
//        info.setUpdatedAt(LocalDateTime.now());
//
//        Teacher teacher=new Teacher();
//        teacher.setAccountId(accountRepository.save(account).getAccountId());
//        teacher.setCreateAt(LocalDateTime.now());
//        teacher.setUpdatedAt(LocalDateTime.now());
//        teacher.setInforId(inforRepository.save(info).getInforId());
//        teacherRepository.save(teacher);
//    }
//
//    @Override
//    public List<TeacherResponse> findAllForView() {
//        List<TeacherResponse> list=new ArrayList<>();
//        for (Teacher item: teacherRepository.findAll())
//        {
//            Info info =inforRepository.findById(item.getInforId()).get();
//            TeacherResponse teacherResponse=new TeacherResponse(
//                    item.getTeacherId(),
//                    info.getFullName(),
//                    info.getDateOfBirth(),
//                    info.getGender(),
//                    info.getAddress(),
//                    info.getPhoneNumber(),
//                    info.getEmail()
//            );
//            list.add(teacherResponse);
//        }
//        return list;
//    }
//
//    @Override
//    public long countTeacher() {
//        return teacherRepository.count();
//    }
//
//
//}
