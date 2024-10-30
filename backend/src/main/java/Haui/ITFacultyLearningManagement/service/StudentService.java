package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.student.request.CreateStudentRequest;
import Haui.ITFacultyLearningManagement.custom.student.response.StudentReponse;
import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Student;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface StudentService  extends  Generate<Student>{
    Optional<Student> findByName(String name);
    Optional<Info> getStudentInfor(int id);
    Student createStudentAccount(CreateStudentRequest createStudentRequest);
    List<StudentReponse>  findAllForView();
    long countStudent();
     List<Student> saveStudentFromExcel(InputStream inputStream) throws Exception;
}
