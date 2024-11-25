package Haui.ITFacultyLearningManagement.custom.course.response;

import Haui.ITFacultyLearningManagement.custom.course.handle.ListCourseHandle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchCourseResponse {
    private int total;
    private List<ListCourseHandle> data;
}
