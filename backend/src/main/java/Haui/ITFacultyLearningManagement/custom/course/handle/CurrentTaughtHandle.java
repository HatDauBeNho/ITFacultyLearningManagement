package Haui.ITFacultyLearningManagement.custom.course.handle;

import java.time.LocalDate;

public interface CurrentTaughtHandle {
    int getCourseId();
    String getCourseName();
    int getCurrentStudent();
    LocalDate getStartTime();
    LocalDate getEndTime();
}
