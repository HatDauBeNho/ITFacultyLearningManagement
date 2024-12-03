package Haui.ITFacultyLearningManagement.controller;

import Haui.ITFacultyLearningManagement.custom.data.CustomResponse;
import Haui.ITFacultyLearningManagement.custom.result.request.EnterResultRequest;
import Haui.ITFacultyLearningManagement.repository.CourseRegistrationRepository;
import Haui.ITFacultyLearningManagement.security.service.UserDetailsImpl;
import Haui.ITFacultyLearningManagement.service.CourseRegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/result")
public class ResultController {
    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @GetMapping("/get")
    public ResponseEntity<?> getResult(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new CustomResponse<>(1, courseRegistrationService.getResult(userDetails.getId()), "Success get result"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PostMapping("/enter")
    public ResponseEntity<?> enterResult(@RequestBody EnterResultRequest request){
        try{
            if (!courseRegistrationService.enterResult(request))
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Can't enter result"));

            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success enter result"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}
