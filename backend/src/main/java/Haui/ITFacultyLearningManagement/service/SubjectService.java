package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.subject.handle.ListSubjectHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.custom.course.response.CurrentTaughtResponse;
import Haui.ITFacultyLearningManagement.custom.course.response.ListStudentInCourseResponse;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.response.RegisteredCourseResponse;
import Haui.ITFacultyLearningManagement.entities.Subject;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Optional;

public interface SubjectService extends Generate<Subject> {
    List<ListSubjectHandle> getAllCourse(String keySearch, Pageable pageable);

    Subject saveCourse(CreateCourseRequest createCourseRequest);

    Optional<Subject> findByCourseName(String courseName);

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

    ListStudentInCourseResponse getListStuInCourse(int teacherId,String keySearch,  Pageable pageable);
}
