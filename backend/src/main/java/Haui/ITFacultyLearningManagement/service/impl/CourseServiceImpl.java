package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.course.handle.CurrentTaughtHandle;
import Haui.ITFacultyLearningManagement.custom.data.CustomResponse;
import Haui.ITFacultyLearningManagement.custom.subject.handle.ListSubjectHandle;
import Haui.ITFacultyLearningManagement.custom.course.handle.ListStudentInCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.custom.course.response.CurrentTaughtResponse;
import Haui.ITFacultyLearningManagement.custom.course.response.ListStudentInCourseResponse;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.handle.RegisteredCourseHandle;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.response.RegisteredCourseResponse;
import Haui.ITFacultyLearningManagement.entities.Classroom;
import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import Haui.ITFacultyLearningManagement.repository.ClassroomRepository;
import Haui.ITFacultyLearningManagement.repository.CourseRegistrationRepository;
import Haui.ITFacultyLearningManagement.repository.CourseRepository;
import Haui.ITFacultyLearningManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.math.RoundingMode;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private ClassroomRepository classroomRepository;

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
    public List<ListSubjectHandle> getCourseBySearch(String keySearch, Pageable pageable) {
        return courseRepository.getCourseBySearch(keySearch,pageable);
    }

    @Override
    public Course saveCourse(CreateCourseRequest request) {
        Course course = new Course(
                request.getCourseName(),
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
    public boolean registerCourse(int classId,int studentId) {
        Optional<Classroom> classroomOptional = classroomRepository.findById(classId);
        if (classroomOptional.isEmpty())
            return false;

        Optional<CourseRegistration> courseRegistrationOptional = courseRegistrationRepository.findByStuAndClass(studentId,classId);
        if (courseRegistrationOptional.isPresent())
            return false;
        Classroom classroom = classroomOptional.get();
        classroom.setCurrentStudent(classroom.getCurrentStudent() + 1);
        classroom.setUpdateTime(LocalDateTime.now());
        classroomRepository.save(classroom);
        CourseRegistration courseRegistration = new CourseRegistration(studentId,classroom.getClassId());
        courseRegistrationRepository.save(courseRegistration);

        return true;
    }

    @Override
    public List<RegisteredCourseHandle> getRegisteredCourse(int studentId){
        return courseRegistrationRepository.getRegisteredCourse(studentId);
    }

    @Override
    public Optional<CourseRegistration> findReByStuIdAndCourseId(int courseId, int studentId) {
        return courseRegistrationRepository.findByStudentIdAndCourseId(courseId, studentId);
    }

    @Override
    public boolean cancelCourse(int classId, int studentId) {
        Optional<Classroom> classroomOptional = classroomRepository.findById(classId);
        if (classroomOptional.isEmpty())
            return false;

        Optional<CourseRegistration> courseRegistrationOptional = courseRegistrationRepository.findByStuAndClass(studentId,classId);
        if (courseRegistrationOptional.isEmpty())
            return false;

        Classroom classroom = classroomOptional.get();
        classroom.setCurrentStudent(classroom.getCurrentStudent() - 1);
        classroom.setUpdateTime(LocalDateTime.now());
        classroomRepository.save(classroom);

        CourseRegistration courseRegistration = courseRegistrationOptional.get();
        courseRegistrationRepository.deleteById(courseRegistration.getCourseRegistrationId());
        return true;
    }

    @Override
    public List<CurrentTaughtHandle> getCurrentTaught(int teacherId) {
        return classroomRepository.getCurrentTaught(teacherId);
    }

    @Override
    public ListStudentInCourseResponse getListStuInCourse( int teacherId, String keySearch, Pageable pageable) {
        int total = courseRepository.getTotalListStuInCourse(keySearch,teacherId);
        List<ListStudentInCourseHandle> list = courseRepository.getListStuInCourse(keySearch,teacherId,pageable);
        return new ListStudentInCourseResponse(total,list);
    }
}
