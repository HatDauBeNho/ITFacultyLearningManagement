package Haui.ITFacultyLearningManagement.controller;

import Haui.ITFacultyLearningManagement.custom.subject.handle.ListSubjectHandle;
import Haui.ITFacultyLearningManagement.custom.course.request.*;
import Haui.ITFacultyLearningManagement.custom.course.response.SearchCourseResponse;
import Haui.ITFacultyLearningManagement.custom.courseRegistration.request.RegisteredCourseRequest;
import Haui.ITFacultyLearningManagement.custom.data.CustomResponse;
import Haui.ITFacultyLearningManagement.entities.*;
import Haui.ITFacultyLearningManagement.repository.StudentRepository;
import Haui.ITFacultyLearningManagement.security.service.UserDetailsImpl;
import Haui.ITFacultyLearningManagement.service.ClassroomService;
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
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private StudentRepository studentRepository;

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
            List<ListSubjectHandle> courseHandleList =  courseService.getCourseBySearch(request.getKeySearch(),pageable);

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

            Optional<Course> conditionOptional= courseService.findById(request.getCondition());
            if (conditionOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Course condition isn't exits"));

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

            Course course = courseOptional.get();
            course.setCourseName(request.getCourseName());
            course.setCredit(request.getCredit());
            course.setUpdateTime(LocalDateTime.now());
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
    public ResponseEntity<?> registeredCourse(){
        try {

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new CustomResponse<>(1,
                    courseService.getRegisteredCourse(userDetails.getId()),
                    "Success get list registered course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PostMapping("/register")
    public  ResponseEntity<?> registerCourse(@RequestParam("classId") Integer classId){
        try {
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            if (!courseService.registerCourse(classId, userDetails.getId()))
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Can't register"));

            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success register course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PostMapping("/cancel")
    public ResponseEntity<?> cancelRegisteredCourse(@RequestParam("classId") Integer classId){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            if (!courseService.cancelCourse(classId, userDetails.getId())){
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Can't cancel"));
            }

            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success delete course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @GetMapping("/currentTaught")
    public ResponseEntity<?> getListCurrentTaught(){
        try{
            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new CustomResponse<>(1,
                    courseService.getCurrentTaught(userDetails.getId())
                    ,"Success get list current taught"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
    //chua test
    @GetMapping("/getListStudent")
    public ResponseEntity<?> getListStudentInCourse(@RequestBody ListStudentInCourseRequest request) {
        try{
            Optional<Course> courseOptional = courseService.findById(request.getCourseId());
            if (courseOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Course isn't exits"));

            Pageable pageable;
            if (request.getOption().getOrder().equals("asc")) {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("full_name").ascending());
            } else {
                pageable = PageRequest.of(request.getOption().getOffset() - 1, request.getOption().getLimit(), JpaSort.unsafe("full_name").descending());
            }

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            return ResponseEntity.ok(new CustomResponse<>(1,
                    courseService.getListStuInCourse(request.getCourseId(), userDetails.getId(), request.getKeySearch(),pageable)
                    ,"Success get list student in course"));
        }catch (Exception e){
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}