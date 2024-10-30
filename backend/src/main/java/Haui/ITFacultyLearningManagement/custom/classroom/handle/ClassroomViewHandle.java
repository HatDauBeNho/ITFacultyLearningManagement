package Haui.ITFacultyLearningManagement.custom.classroom.handle;

import java.time.LocalDateTime;

public interface ClassroomViewHandle {
    Integer getClassID();
    String getClassName();
    Integer getQuantity();
    String getMajorName();
    String getFullName();
    String getPhoneNumber();
    LocalDateTime getCreateTime();
    LocalDateTime getUpdateTime();
}
