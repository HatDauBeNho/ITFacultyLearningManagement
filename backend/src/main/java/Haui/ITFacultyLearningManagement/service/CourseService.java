package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.entities.Course;
import java.util.Optional;

public interface CourseService extends Generate<Course> {
    Optional<Course> findByName(String name);
}
