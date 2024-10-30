package Haui.ITFacultyLearningManagement.custom.classroom.request;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditClassroomRequest {
    private int classId;
    private String className;
    private Integer quantity;
    private String majorName;
    private String fullName;
}
