package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.student.handle.SearchStudentHandle;
import Haui.ITFacultyLearningManagement.custom.student.request.CreateStudentRequest;
import Haui.ITFacultyLearningManagement.custom.student.response.StudentReponse;
import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.io.InputStream;
import java.util.List;
import java.util.Optional;

public interface StudentService  extends  Generate<Student>{

    List<SearchStudentHandle> getStudentWithSearch(String keySearch, Pageable pageable);

    Integer getTotal(String keySearch);

}
