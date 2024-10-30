package Haui.ITFacultyLearningManagement.custom.classroom.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateClassroomRequest {
    private String className;
    private int quantity;
    private String majorName;
    private String fullName;
}
