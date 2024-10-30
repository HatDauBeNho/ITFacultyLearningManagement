package Haui.ITFacultyLearningManagement.service;

import Haui.ITFacultyLearningManagement.custom.classroom.handle.ClassroomViewHandle;
import Haui.ITFacultyLearningManagement.custom.classroom.response.ClassroomViewResponse;
import Haui.ITFacultyLearningManagement.entities.Classroom;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ClassroomService extends Generate<Classroom> {
    Optional<Classroom> findByName(String name);
    ClassroomViewResponse getClassroomsPageable(String keySearch, Pageable pageable);


}
