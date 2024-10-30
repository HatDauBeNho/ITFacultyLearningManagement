package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.classroom.handle.ClassroomViewHandle;
import Haui.ITFacultyLearningManagement.custom.classroom.response.ClassroomViewResponse;
import Haui.ITFacultyLearningManagement.entities.Classroom;
import Haui.ITFacultyLearningManagement.repository.*;
import Haui.ITFacultyLearningManagement.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;
    @Autowired
    private TeacherRepository teacherRepository;
    @Autowired
    private InfoRepository infoRepository;
    @Autowired
    private MajorRepository majorRepository;


    @Override
    public List<Classroom> findAll() {
        return classroomRepository.findAll();
    }

    @Override
    public Optional<Classroom> findById(Integer id) {
        return classroomRepository.findById(id);
    }

    @Override
    public Classroom save(Classroom classroom) {
        return classroomRepository.save(classroom);
    }

    @Override
    public void deleteById(Integer id) {
        classroomRepository.deleteById(id);
    }

    @Override
    public Optional<Classroom> findByName(String name) {
        return classroomRepository.findByName(name);
    }

    @Override
    public ClassroomViewResponse getClassroomsPageable(String keySearch, Pageable pageable) {
        return  new ClassroomViewResponse(
                classroomRepository.getTotalClassroomsPageable(keySearch),
                classroomRepository.getClassroomsPageable(keySearch,pageable));
    }
}
