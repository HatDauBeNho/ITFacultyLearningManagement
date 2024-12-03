package Haui.ITFacultyLearningManagement.custom.classroom.response;

import Haui.ITFacultyLearningManagement.custom.classroom.handle.GetClassroomHandle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetClassroomResponse {
    private int total;
    private List<GetClassroomHandle> data;
}
