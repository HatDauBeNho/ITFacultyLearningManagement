//package Haui.ITFacultyLearningManagement.controller;
//
//import Haui.ITFacultyLearningManagement.custom.data.reponse.CustomResponse;
//import Haui.ITFacultyLearningManagement.custom.student.request.CreateStudentRequest;
//import Haui.ITFacultyLearningManagement.service.AccountService;
//import Haui.ITFacultyLearningManagement.service.ClassroomService;
//import Haui.ITFacultyLearningManagement.service.InfoService;
//import Haui.ITFacultyLearningManagement.service.StudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.Errors;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import javax.transaction.Transactional;
//import javax.validation.Valid;
//
//
//@RestController
//@RequestMapping("/student")
//public class StudentController {
//    @Autowired
//    private StudentService studentService;
//    @Autowired
//    private InfoService infoService;
//    @Autowired
//    private AccountService accountService;
//    @Autowired
//    private ClassroomService classroomService;
//
//    @PostMapping("/saveStudentFromExcel")
//    @Transactional
//    public ResponseEntity<?> createStudentFromExcel(@RequestBody MultipartFile file)
//    {
//        try
//        {
//            if (file.isEmpty())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "File is empty"));
//
//            return ResponseEntity.ok(new CustomResponse<>(1,
//                    null,
//                    "Success create "+studentService.saveStudentFromExcel(file.getInputStream()).size()+" student"));
//
//        }catch (Exception e)
//        {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Save failed"));
//        }
//    }
//
//    @PostMapping("/createStudent")
//    @Transactional
//    public ResponseEntity<?> createStudent(@Valid @RequestBody CreateStudentRequest request, Errors errors) {
//        try {
//            if (studentService.findByName(request.getFullName()).isPresent())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Student already exists"));
//            if (classroomService.findByName(request.getClassName()).isEmpty())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Class is not exists"));
//            if (errors.hasErrors()) {
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, errors.getAllErrors().toString()));
//            }
//            studentService.createStudentAccount(request);
//            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create student"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//    @GetMapping("/getAll")
//    public ResponseEntity<?> getAllStudent(){
//        try
//        {
//            return ResponseEntity.ok(new CustomResponse<>(1, studentService.findAllForView(), null));
//        }catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//
//}
