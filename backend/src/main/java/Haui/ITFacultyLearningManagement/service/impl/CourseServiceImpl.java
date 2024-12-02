package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.course.handle.ListCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.handle.SearchRegisteredCourseHandle;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.response.SearchRegisteredCourseResponse;
import Haui.ITFacultyLearningManagement.custom.data.CustomResponse;
import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import Haui.ITFacultyLearningManagement.repository.CourseRegistrationRepository;
import Haui.ITFacultyLearningManagement.repository.CourseRepository;
import Haui.ITFacultyLearningManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

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

    @Override
    public Optional<CourseRegistration> findByName(String name) {
        return courseRegistrationRepository.findByName(name);
    }

    @Override
    public List<CourseRegistration> findByStudentId(Integer studentId) {
        return courseRegistrationRepository.findByStudentId(studentId);
    }

    @Override
    public double getGPA(Integer studentId) {
        if (courseRegistrationRepository.findByStudentId(studentId).isEmpty())
            return 0;
        double sum = 0;
        for(CourseRegistration item: courseRegistrationRepository.findByStudentId(studentId))
        {
            sum = sum+item.getPoint();
        }
        double result = sum/courseRegistrationRepository.findByStudentId(studentId).size();
        BigDecimal roundedResult=new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return roundedResult.doubleValue();
    }

    @Override
    public boolean checkCondition(int courseId, int studentId) {
        Optional<Course> courseOptional = courseRepository.findById(courseId);
        if (courseOptional.isEmpty())
            return false;

        Course  course = courseOptional.get();
        if (course.getStartTime().minusWeeks(1).isAfter(LocalDate.now()))
        {
            return false;
        }

        Optional<CourseRegistration> courseRegistrationOptional = courseRegistrationRepository.findByStudentIdAndCourseId(courseId,studentId);
        if (courseRegistrationOptional.isPresent())
            return  false;

        int condition = course.getCondition();
        if (condition == 0)
            return true;

        Optional<CourseRegistration> courseRegistrationCondition = courseRegistrationRepository.findByStudentIdAndCourseId(condition,studentId);
        if (courseRegistrationCondition.isEmpty())
            return false;

        if (courseRegistrationCondition.get().getPoint() < 4)
            return false;

        return true;
    }

    @Override
    public boolean registerCourse(int courseId, int studentId) {
        CourseRegistration courseRegistration =  new CourseRegistration(
                studentId,
                courseId
        );
        Optional<Course> courseOptional =  courseRepository.findById(courseId);
        if (courseOptional.isEmpty()) {
            return false;
        }
        Course course =  courseOptional.get();
        course.setCurrentStudent(course.getCurrentStudent() + 1);
        course.setUpdateTime(LocalDateTime.now());
        courseRepository.save(course);
        courseRegistrationRepository.save(courseRegistration);
        return true;
    }

    @Override
    public SearchRegisteredCourseResponse findCourseRegistrationBySearch(Pageable pageable) {
        int total = courseRegistrationRepository.getTotal();
        List<SearchRegisteredCourseHandle> data = courseRegistrationRepository.getAllCourseRegistration(pageable);
        return new SearchRegisteredCourseResponse(total,data);
    }

    @Override
    public Optional<CourseRegistration> findReByStuIdAndCourseId(int courseId, int studentId) {
        return courseRegistrationRepository.findByStudentIdAndCourseId(courseId, studentId);
    }

    @Override
    public boolean deleteCourseRegistration(int courseRegistrationId) {
        Optional<CourseRegistration> courseRegistrationOptional = courseRegistrationRepository.findById(courseRegistrationId);
        if (courseRegistrationOptional.isEmpty())
            return false;

        Optional<Course> courseOptional= courseRepository.findById(courseRegistrationOptional.get().getCourseId());
        if (courseOptional.isEmpty())
            return false;

        Course course = courseOptional.get();
        course.setCurrentStudent(course.getCurrentStudent()-1);

        courseRegistrationRepository.deleteById(courseRegistrationId);
        return true;
    }
}
