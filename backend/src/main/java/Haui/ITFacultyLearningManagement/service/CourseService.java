package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.course.handle.ListCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.custom.course.response.CurrentTaughtResponse;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.response.RegisteredCourseResponse;
import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface CourseService extends Generate<Course> {
    List<ListCourseHandle> getAllCourse(String keySearch, Pageable pageable);

    Course saveCourse(CreateCourseRequest createCourseRequest);

    Optional<Course> findByCourseName(String courseName);

    Integer totalAllCourse(String keySearch);

    Optional<CourseRegistration> findByName(String name);

    List<CourseRegistration> findByStudentId(Integer studentId);

    double getGPA(Integer studentId);

    boolean checkCondition(int courseId, int studentId);

    boolean registerCourse(int courseId, int studentId);

    RegisteredCourseResponse getCourseRegistration(int studentId,Pageable pageable);

    Optional<CourseRegistration> findReByStuIdAndCourseId(int courseId,int studentId);

    boolean deleteCourseRegistration(int courseRegistrationId);

    CurrentTaughtResponse getCurrentTaught(int teacherId, Pageable pageable);


}
