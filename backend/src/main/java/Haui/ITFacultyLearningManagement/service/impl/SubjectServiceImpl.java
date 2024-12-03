package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.subject.handle.ListSubjectHandle;
import Haui.ITFacultyLearningManagement.custom.course.handle.ListStudentInCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.custom.course.response.CurrentTaughtResponse;
import Haui.ITFacultyLearningManagement.custom.course.response.ListStudentInCourseResponse;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.handle.RegisteredCourseHandle;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.response.RegisteredCourseResponse;
import Haui.ITFacultyLearningManagement.entities.Subject;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import Haui.ITFacultyLearningManagement.repository.CourseRegistrationRepository;
import Haui.ITFacultyLearningManagement.repository.SubjectRepository;
import Haui.ITFacultyLearningManagement.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubjectServiceImpl implements SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Override
    public List<Subject> findAll() {
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> findById(Integer id) {
        return subjectRepository.findById(id);
    }

    @Override
    public Subject save(Subject subject) {
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteById(Integer id) {
        subjectRepository.deleteById(id);
    }

    @Override
    public List<ListSubjectHandle> getAllCourse(String keySearch, Pageable pageable) {
        return subjectRepository.getAllCourse(keySearch,pageable);
    }

    @Override
    public Subject saveCourse(CreateCourseRequest request) {
        Subject subject = new Subject(
                request.getCourseName(),
                request.getMaximumStudent(),
                request.getTeacherId(),
                request.getCondition(),
                request.getCredit()
        );

        return subjectRepository.save(subject);
    }

    @Override
    public Optional<Subject> findByCourseName(String courseName) {
        return subjectRepository.findByCourseName(courseName);
    }

    @Override
    public Integer totalAllCourse(String keySearch) {
        return subjectRepository.totalAllCourse(keySearch);
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
        Optional<Subject> courseOptional = subjectRepository.findById(courseId);
        if (courseOptional.isEmpty())
            return false;

        Subject subject = courseOptional.get();
        if (subject.getStartTime().minusWeeks(1).isAfter(LocalDate.now()))
        {
            return false;
        }

        Optional<CourseRegistration> courseRegistrationOptional = courseRegistrationRepository.findByStudentIdAndCourseId(courseId,studentId);
        if (courseRegistrationOptional.isPresent())
            return  false;

        int condition = subject.getCondition();
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
        Optional<Subject> courseOptional =  subjectRepository.findById(courseId);
        if (courseOptional.isEmpty()) {
            return false;
        }
        Subject subject =  courseOptional.get();
        subject.setCurrentStudent(subject.getCurrentStudent() + 1);
        subject.setUpdateTime(LocalDateTime.now());
        subjectRepository.save(subject);
        courseRegistrationRepository.save(courseRegistration);
        return true;
    }

    @Override
    public RegisteredCourseResponse getCourseRegistration(int studentId,Pageable pageable) {
        int total = courseRegistrationRepository.getTotal(studentId);
        List<RegisteredCourseHandle> data = courseRegistrationRepository.getAllCourseRegistration(studentId,pageable);
        return new RegisteredCourseResponse(total,data);
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

        Optional<Subject> courseOptional= subjectRepository.findById(courseRegistrationOptional.get().getCourseId());
        if (courseOptional.isEmpty())
            return false;

        Subject subject = courseOptional.get();
        subject.setCurrentStudent(subject.getCurrentStudent()-1);

        courseRegistrationRepository.deleteById(courseRegistrationId);
        return true;
    }

    @Override
    public CurrentTaughtResponse getCurrentTaught(int teacherId, Pageable pageable) {
        return new CurrentTaughtResponse(subjectRepository.getTotalCurrentTaught(teacherId), subjectRepository.getCurrentTaught(teacherId, pageable));
    }

    @Override
    public ListStudentInCourseResponse getListStuInCourse( int teacherId, String keySearch, Pageable pageable) {
        int total = subjectRepository.getTotalListStuInCourse(keySearch,teacherId);
        List<ListStudentInCourseHandle> list = subjectRepository.getListStuInCourse(keySearch,teacherId,pageable);
        return new ListStudentInCourseResponse(total,list);
    }
}
