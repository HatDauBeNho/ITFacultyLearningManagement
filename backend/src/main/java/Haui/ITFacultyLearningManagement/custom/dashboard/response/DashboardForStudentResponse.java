package Haui.ITFacultyLearningManagement.custom.dashboard.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DashboardForStudentResponse {
    private double gpa;
    private int countRegisteredCourse;
    private String semesterName;
}
