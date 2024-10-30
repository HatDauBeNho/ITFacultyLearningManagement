package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import Haui.ITFacultyLearningManagement.repository.CourseRegistrationRepository;
import Haui.ITFacultyLearningManagement.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Optional;

@Service
public class CourseRegistrationServiceImpl implements CourseRegistrationService {
    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

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
        double sum=0;
        for(CourseRegistration item: courseRegistrationRepository.findByStudentId(studentId))
        {
            sum=sum+item.getPoint();
        }
        double result=sum/courseRegistrationRepository.findByStudentId(studentId).size();
        BigDecimal roundedResult=new BigDecimal(result).setScale(2, RoundingMode.HALF_UP);
        return roundedResult.doubleValue();
    }

    @Override
    public List<CourseRegistration> findAll() {
        return courseRegistrationRepository.findAll();
    }

    @Override
    public Optional<CourseRegistration> findById(Integer id) {
        return courseRegistrationRepository.findById(id);
    }

    @Override
    public CourseRegistration save(CourseRegistration courseRegistration) {
        return courseRegistrationRepository.save(courseRegistration);
    }

    @Override
    public void deleteById(Integer id) {
        courseRegistrationRepository.deleteById(id);
    }
}
