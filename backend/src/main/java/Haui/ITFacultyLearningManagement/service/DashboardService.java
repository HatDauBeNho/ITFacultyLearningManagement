package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.dashboard.handle.DashboardLectureHandle;
import Haui.ITFacultyLearningManagement.custom.dashboard.handle.DashboardStudentHandle;

public interface DashboardService {
    DashboardStudentHandle getDashboardForStudent(int studentId);

    DashboardLectureHandle getDashboardForLecture(int lectureId);
}
