package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.classroom.handle.GetClassroomHandle;
import Haui.ITFacultyLearningManagement.custom.classroom.request.CreateClassroomRequest;
import Haui.ITFacultyLearningManagement.custom.classroom.request.GetClassroomRequest;
import Haui.ITFacultyLearningManagement.custom.classroom.response.GetClassroomResponse;
import Haui.ITFacultyLearningManagement.entities.Classroom;
import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.entities.Semester;
import Haui.ITFacultyLearningManagement.entities.Teacher;
import Haui.ITFacultyLearningManagement.repository.ClassroomRepository;
import Haui.ITFacultyLearningManagement.repository.CourseRepository;
import Haui.ITFacultyLearningManagement.repository.SemesterRepository;
import Haui.ITFacultyLearningManagement.repository.TeacherRepository;
import Haui.ITFacultyLearningManagement.service.ClassroomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class ClassroomServiceImpl implements ClassroomService {
    @Autowired
    private ClassroomRepository classroomRepository;

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private SemesterRepository semesterRepository;

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
    public boolean createClassroom(CreateClassroomRequest request) {
        Optional<Course> courseOptional =  courseRepository.findById(request.getCourseId());
        if (courseOptional.isEmpty())
            return false;

        Optional<Teacher> teacherOptional =teacherRepository.findById(request.getTeacherId());
        if (teacherOptional.isEmpty())
            return false;

        Optional<Semester> semesterOptional = semesterRepository.findById(request.getSemesterId());
        if (semesterOptional.isEmpty())
            return false;

        if (request.getMaximumStudent() > 60)
            return false;

        Classroom classroom = new Classroom(request.getMaximumStudent(), request.getTeacherId(), request.getCourseId(), request.getSemesterId());
        classroomRepository.save(classroom);
        return true;
    }

    @Override
    public GetClassroomResponse getClassBySearchAndSemester(GetClassroomRequest request, Pageable pageable) {
        int total = classroomRepository.getTotalBySearchAndSemester(request.getKeySearch(), request.getSemesterId());

        List<GetClassroomHandle> list = classroomRepository.getClassBySearchAndSemester(request.getKeySearch(), request.getSemesterId(),pageable);
        return new GetClassroomResponse(total,list);
    }
}
