package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.teacher.request.CreateTeacherRequest;
import Haui.ITFacultyLearningManagement.custom.teacher.response.TeacherResponse;
import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Teacher;
import org.springframework.data.repository.query.Param;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface TeacherService extends Generate<Teacher> {
    Optional<Teacher> findByName(String name);

    Optional<Teacher> findByAccountId( int accountId);

}
