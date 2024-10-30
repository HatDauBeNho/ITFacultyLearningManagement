package Haui.ITFacultyLearningManagement.custom.department.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EditDepartmentRequest {
    private int departmentId;
    private String departmentName;
    private String teacherName;
}
