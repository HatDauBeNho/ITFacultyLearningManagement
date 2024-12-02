package Haui.ITFacultyLearningManagement.controller;

import Haui.ITFacultyLearningManagement.custom.course.handle.ListCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.CreateCourseRequest;
import Haui.ITFacultyLearningManagement.custom.course.request.CurrentTaughtRequest;
import Haui.ITFacultyLearningManagement.custom.course.request.SearchCourseRequest;
import Haui.ITFacultyLearningManagement.custom.course.request.UpdateCourseRequest;
import Haui.ITFacultyLearningManagement.custom.course.response.SearchCourseResponse;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.request.RegisteredCourseRequest;
import Haui.ITFacultyLearningManagement.custom.data.CustomResponse;
import Haui.ITFacultyLearningManagement.entities.Course;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import Haui.ITFacultyLearningManagement.entities.Teacher;
import Haui.ITFacultyLearningManagement.security.service.UserDetailsImpl;
import Haui.ITFacultyLearningManagement.service.CourseService;
import Haui.ITFacultyLearningManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.JpaSort;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/search")
    public ResponseEntity<?> getCourseWithSearch(@RequestBody SearchCourseRequest request){
        try{
            Pageable pageable;
            if (request.getOption().getOrder().equals("asc")) {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").ascending());
            } else {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").descending());
            }

            Integer total =  courseService.totalAllCourse(request.getKeySearch());
            List<ListCourseHandle> courseHandleList =  courseService.getAllCourse(request.getKeySearch(),pageable);

            return ResponseEntity.ok(new CustomResponse<>(1, new SearchCourseResponse(total, courseHandleList), "Success get list course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PostMapping("create")
    public ResponseEntity<?> createCourse(@RequestBody CreateCourseRequest request)
    {
        try{
            Optional<Course> courseOptional = courseService.findByCourseName(request.getCourseName());
            if (courseOptional.isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Course already exits"));

            if (request.getMaximumStudent() > 100 )
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Too many student"));

            Optional<Teacher> teacherOptional = teacherService.findById(request.getTeacherId());
            if (teacherOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher isn't exits"));

            courseService.saveCourse(request);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create course"));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));

        }
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateCourse(@RequestBody UpdateCourseRequest request)
    {
        try{
            Optional<Course> courseOptional = courseService.findById(request.getCourseId());
            if (courseOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Course isn't exits"));

            if ( request.getStartTime().isBefore(LocalDate.now())) {
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Invalid time period"));
            }

            Course course = courseOptional.get();
            course.setStartTime(request.getStartTime());
            course.setEndTime(request.getStartTime().plusMonths(3));
            courseService.save(course);

            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success update course"));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteCourse(@RequestParam("courseId") Integer courseId){
        try{
            Optional<Course> courseOptional = courseService.findById(courseId);
            if (courseOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Course isn't exits"));

            courseService.deleteById(courseId);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success delete course"));

        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @GetMapping("registeredCourse")
    public ResponseEntity<?> searchRegisteredCourse(@RequestBody RegisteredCourseRequest request){
        try {
            Pageable pageable;
            if (request.getOption().getOrder().equals("asc")) {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").ascending());
            } else {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").descending());
            }

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new CustomResponse<>(1,
                    courseService.getCourseRegistration(userDetails.getId(),pageable),
                    "Success get list registered course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PostMapping("/register")
    public  ResponseEntity<?> registerCourse(@RequestParam("courseId") Integer courseId){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            if (!courseService.checkCondition(courseId,userDetails.getId())){
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Not eligible to register"));
            }

            if (!courseService.registerCourse(courseId, userDetails.getId())){
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Can't register"));
            }

            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success register course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelRegisteredCourse(@RequestParam("courseId") Integer courseId){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            Optional<CourseRegistration> courseRegistrationOptional = courseService.findReByStuIdAndCourseId(courseId, userDetails.getId());
            if (courseRegistrationOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Not found registered course"));

            if (!courseService.deleteCourseRegistration(courseRegistrationOptional.get().getCourseRegistrationId())){
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Can't cancel"));
            }

            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success delete course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    //chua test
    @GetMapping("/currentTaught")
    public ResponseEntity<?> searchCurrentTaught(@RequestBody CurrentTaughtRequest request){
        try{
            Pageable pageable;
            if (request.getOption().getOrder().equals("asc")) {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").ascending());
            } else {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("create_time").descending());
            }

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new CustomResponse<>(1,
                    courseService.getCurrentTaught(userDetails.getId(), pageable)
                    ,"Success delete course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

}
