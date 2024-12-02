package Haui.ITFacultyLearningManagement.custom.evaluate.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluateRequest {
    private double rating;
    private int teacherId;
    private String content;
}
