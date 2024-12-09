package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.dashboard.handle.DashboardLectureHandle;
import Haui.ITFacultyLearningManagement.custom.dashboard.handle.DashboardStudentHandle;
import Haui.ITFacultyLearningManagement.custom.dashboard.response.DashboardAdminResponse;

public interface DashboardService {
    DashboardStudentHandle getDashboardStudent(int studentId);

    DashboardLectureHandle getDashboardLecture(int lectureId);

    DashboardAdminResponse getDashboardAdmin();
}
