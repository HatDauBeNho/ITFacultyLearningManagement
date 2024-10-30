package Haui.ITFacultyLearningManagement.custom.subject.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateSubjectRequest {
    private String subjectName;
    private int credit;
    private String departmentName;
}
