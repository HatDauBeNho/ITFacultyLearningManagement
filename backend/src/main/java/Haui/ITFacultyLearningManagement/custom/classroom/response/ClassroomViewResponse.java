package Haui.ITFacultyLearningManagement.custom.classroom.response;

import Haui.ITFacultyLearningManagement.custom.classroom.handle.ClassroomViewHandle;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClassroomViewResponse {
    private Integer total;
    private List<ClassroomViewHandle> data;
}
