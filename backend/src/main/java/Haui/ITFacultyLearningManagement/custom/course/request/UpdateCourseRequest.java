package Haui.ITFacultyLearningManagement.custom.course.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateCourseRequest {
    private Integer id;
    private LocalDate startTime;
}