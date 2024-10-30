package Haui.ITFacultyLearningManagement.custom.dashboard.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DashboardForAdminResponse {
    private long countDepartment;
    private long countMajor;
    private long countTeacher;
    private long countStudent;
    private long countSubject;
}
