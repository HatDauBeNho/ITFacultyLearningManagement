package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.dashboard.handle.DashboardLectureHandle;
import Haui.ITFacultyLearningManagement.custom.dashboard.handle.DashboardStudentHandle;
import Haui.ITFacultyLearningManagement.custom.dashboard.response.DashboardAdminResponse;
import Haui.ITFacultyLearningManagement.repository.*;
import Haui.ITFacultyLearningManagement.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardServiceImpl implements DashboardService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private LectureRepository lectureRepository;

    @Autowired
    private CourseRegistrationRepository courseRegistrationRepository;

    @Autowired
    private SemesterRepository semesterRepository;

    @Override
    public DashboardStudentHandle getDashboardStudent(int studentId) {
        return semesterRepository.getDashboardStudent(studentId);
    }

    @Override
    public DashboardLectureHandle getDashboardLecture(int lectureId) {
        return semesterRepository.getDashboardLecture(lectureId);
    }

    @Override
    public DashboardAdminResponse getDashboardAdmin() {
        int countStudent= studentRepository.countStudent();
        int countLecture = lectureRepository.countLecture();
        return new DashboardAdminResponse(countLecture,countStudent);
    }
}
