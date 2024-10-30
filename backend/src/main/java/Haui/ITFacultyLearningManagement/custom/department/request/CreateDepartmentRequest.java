package Haui.ITFacultyLearningManagement.custom.department.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateDepartmentRequest {
    private String departmentName;
    private String fullName;
}
