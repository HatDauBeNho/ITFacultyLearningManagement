package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.entities.CourseRegistration;

import java.util.List;
import java.util.Optional;

public interface CourseRegistrationService extends Generate<CourseRegistration> {
    Optional<CourseRegistration> findByName(String name);

    List<CourseRegistration> findByStudentId(Integer studentId);

    double getGPA(Integer studentId);
}
