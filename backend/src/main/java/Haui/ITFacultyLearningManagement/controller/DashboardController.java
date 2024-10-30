package Haui.ITFacultyLearningManagement.controller;

import Haui.ITFacultyLearningManagement.custom.classroom.request.CreateClassroomRequest;
import Haui.ITFacultyLearningManagement.custom.data.reponse.CustomResponse;

import Haui.ITFacultyLearningManagement.entities.Classroom;
import Haui.ITFacultyLearningManagement.service.ClassroomService;
import Haui.ITFacultyLearningManagement.service.MajorService;
import Haui.ITFacultyLearningManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping
public class DashboardController {
    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private TeacherService teacherService;






}
