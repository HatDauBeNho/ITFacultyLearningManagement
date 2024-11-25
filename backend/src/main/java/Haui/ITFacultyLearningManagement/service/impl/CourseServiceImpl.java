package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.course.handle.ListCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.repository.CourseRepository;
import Haui.ITFacultyLearningManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.plaf.IconUIResource;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> findAll() {
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return courseRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public void deleteById(Integer id) {
        courseRepository.deleteById(id);
    }

    @Override
    public List<ListCourseHandle> getAllCourse(String keySearch, Pageable pageable) {
        return courseRepository.getAllCourse(keySearch,pageable);
    }

    @Override
    public Course saveCourse(CreateCourseRequest request) {
        Course course = new Course(
                request.getCourseName(),
                request.getMaximumStudent(),
                request.getTeacherId(),
                request.getCondition(),
                request.getCredit()
        );

        return courseRepository.save(course);
    }

    @Override
    public Optional<Course> findByCourseName(String courseName) {
        return courseRepository.findByCourseName(courseName);
    }

    @Override
    public Integer totalAllCourse(String keySearch) {
        return courseRepository.totalAllCourse(keySearch);
    }
}
