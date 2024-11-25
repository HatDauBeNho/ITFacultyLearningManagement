package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.course.handle.ListCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.entities.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;


import java.util.List;
import java.util.Optional;

public interface CourseService extends Generate<Course> {
    List<ListCourseHandle> getAllCourse(String keySearch, Pageable pageable);

    Course saveCourse(CreateCourseRequest createCourseRequest);

    Optional<Course> findByCourseName(String courseName);

    Integer totalAllCourse(@Param("keySearch") String keySearch);

}
