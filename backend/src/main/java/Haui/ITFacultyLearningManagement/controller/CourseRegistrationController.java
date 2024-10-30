//package Haui.ITFacultyLearningManagement.controller;
//
//import Haui.ITFacultyLearningManagement.custom.data.reponse.CustomResponse;
//import Haui.ITFacultyLearningManagement.custom.result.request.ResultRequest;
//import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
//import Haui.ITFacultyLearningManagement.service.CourseRegistrationService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.time.LocalDateTime;
//import java.util.Optional;
//
//@RestController
//@RequestMapping("/courseRegistration")
//public class CourseRegistrationController {
//    @Autowired
//    private CourseRegistrationService courseRegistrationService;
//
//    @PostMapping("/teacher/enterResult")
//    public ResponseEntity<?> enterResult(@RequestBody ResultRequest resultRequest)
//    {
//        try
//        {
//            Optional<CourseRegistration> courseRegistrationOptional=courseRegistrationService.findById(resultRequest.getCourseRegistrationId());
//            if (courseRegistrationOptional.isEmpty())
//            {
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Course registration isn't exits"));
//            }
//            CourseRegistration courseRegistration=courseRegistrationOptional.get();
//            courseRegistration.setPoint(resultRequest.getPoint());
//            courseRegistration.setUpdatedAt(LocalDateTime.now());
//            courseRegistrationService.save(courseRegistration);
//            return ResponseEntity.ok(new CustomResponse<>(1, null, "success enter result"));
//
//        }catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//}
