package Haui.ITFacultyLearningManagement.custom.courseRegistration.handle;

import java.time.LocalDate;
import java.time.LocalDateTime;

public interface SearchRegisteredCourseHandle {
    String getCourseName();
    Integer getCurrentStudent();
    Integer getMaximumStudent();
    String getFullName();
    LocalDate getStartTime();
    LocalDate getEndTime();
    LocalDateTime getCreateTime();
}