package Haui.ITFacultyLearningManagement.service.impl;

import Haui.ITFacultyLearningManagement.custom.dashboard.response.DashboardForStudentResponse;
import Haui.ITFacultyLearningManagement.repository.CourseRegistrationRepository;
import Haui.ITFacultyLearningManagement.repository.CourseRepository;
import Haui.ITFacultyLearningManagement.repository.SemesterRepository;
import Haui.ITFacultyLearningManagement.repository.StudentRepository;
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
    private SemesterRepository semesterRepository;

    @Override
    public DashboardForStudentResponse getDashboardForStudent() {
        return null;
    }
}
