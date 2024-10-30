package Haui.ITFacultyLearningManagement.custom.department.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DepartmentResponse {
    private int departmentId;
    private String departmentName;
    private String fullName;
    private LocalDateTime createAt;
    private LocalDateTime updateAt;
}
