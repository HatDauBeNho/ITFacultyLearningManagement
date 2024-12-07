package Haui.ITFacultyLearningManagement.controller;

import Haui.ITFacultyLearningManagement.custom.data.CustomResponse;
import Haui.ITFacultyLearningManagement.security.service.UserDetailsImpl;
import Haui.ITFacultyLearningManagement.service.ClassroomService;
import Haui.ITFacultyLearningManagement.service.TeacherService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {
    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/student")
    public ResponseEntity<?> getDashboardForStudent(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success get dash board"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }

    }





}
