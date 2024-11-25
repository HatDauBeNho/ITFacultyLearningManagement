package Haui.ITFacultyLearningManagement.controller;

import Haui.ITFacultyLearningManagement.custom.course.request.SearchCourseRequest;
import Haui.ITFacultyLearningManagement.custom.data.CustomResponse;
import Haui.ITFacultyLearningManagement.custom.result.request.ResultRequest;
import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import Haui.ITFacultyLearningManagement.service.CourseRegistrationService;
import Haui.ITFacultyLearningManagement.service.CourseService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/api/courseRegistration")
public class CourseRegistrationController {
    @Autowired
    private CourseRegistrationService courseRegistrationService;

    @Autowired
    private CourseService courseService;

//    @PostMapping("/search")
//    public ResponseEntity<?> getCourseRegistrationWithSearch(@RequestBody SearchCourseRequest request){
//        try{
//            Pageable pageable;
//            if (request.getOption().getOrder().equals("asc")) {
//                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").ascending());
//            } else {
//                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").descending());
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }

    @PostMapping("/register")
    public  ResponseEntity<?> registerCourse(@RequestParam("courseId") Integer courseId){
        try {
            Optional<Course> courseOptional = courseService.findById(courseId);
            if (courseOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Course isn't exits"));



        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}
