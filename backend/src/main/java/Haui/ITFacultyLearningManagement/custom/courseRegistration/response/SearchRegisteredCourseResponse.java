package Haui.ITFacultyLearningManagement.custom.courseRegistration.response;

import Haui.ITFacultyLearningManagement.custom.courseRegistration.handle.SearchRegisteredCourseHandle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SearchRegisteredCourseResponse {
    private int total;
    private List<SearchRegisteredCourseHandle> data;
}
