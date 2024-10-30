package Haui.ITFacultyLearningManagement.custom.subject.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponse {
    private int subjectId;
    private String subjectName;
    private int credit;
    private String departmentName;
}
