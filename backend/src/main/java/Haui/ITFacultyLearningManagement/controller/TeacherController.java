//package Haui.ITFacultyLearningManagement.controller;
//
//import Haui.ITFacultyLearningManagement.custom.data.reponse.CustomResponse;
//import Haui.ITFacultyLearningManagement.custom.teacher.request.CreateTeacherRequest;
//import Haui.ITFacultyLearningManagement.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/teacher")
//public class TeacherController {
//    @Autowired
//    private TeacherService teacherService;
//
//    @PostMapping("/admin/createStudent")
//    public ResponseEntity<?> createStudent(@RequestBody CreateTeacherRequest request, Errors errors) {
//        try
//        {
//            if (teacherService.findByName(request.getFullName()).isPresent())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher already exists"));
//            if (errors.hasErrors()) {
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Incorrect input format"));
//            }
//            teacherService.createTeacherAccount(request);
//            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create teacher"));
//        }catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//
//}
