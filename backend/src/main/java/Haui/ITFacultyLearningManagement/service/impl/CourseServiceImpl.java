package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.repository.ModuleSubjectRepository;
import Haui.ITFacultyLearningManagement.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private ModuleSubjectRepository moduleSubjectRepository;
    @Override
    public Optional<Course> findByName(String name) {
        return moduleSubjectRepository.findByName(name);
    }

    @Override
    public List<Course> findAll() {
        return moduleSubjectRepository.findAll();
    }

    @Override
    public Optional<Course> findById(Integer id) {
        return moduleSubjectRepository.findById(id);
    }

    @Override
    public Course save(Course course) {
        return moduleSubjectRepository.save(course);
    }

    @Override
    public void deleteById(Integer id) {
        moduleSubjectRepository.deleteById(id);
    }
}
