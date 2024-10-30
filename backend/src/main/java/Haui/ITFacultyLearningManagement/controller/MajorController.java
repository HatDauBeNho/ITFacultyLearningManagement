//package Haui.ITFacultyLearningManagement.controller;
//
//import Haui.ITFacultyLearningManagement.custom.data.reponse.CustomResponse;
//import Haui.ITFacultyLearningManagement.custom.major.request.CreateMajorRequest;
//import Haui.ITFacultyLearningManagement.custom.major.request.EditMajorRequest;
//import Haui.ITFacultyLearningManagement.entities.Major;
//import Haui.ITFacultyLearningManagement.service.MajorService;
//import Haui.ITFacultyLearningManagement.service.TeacherService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.time.LocalDateTime;
//
//@RestController
//@RequestMapping("/major")
//public class MajorController {
//    @Autowired
//    private MajorService majorService;
//
//    @Autowired
//    private TeacherService teacherService;
//
//    @PostMapping("admin/createMajor")
//    public ResponseEntity<?> createMajor(@RequestBody CreateMajorRequest request) {
//        try {
//            if (majorService.findByName(request.getMajorName()).isPresent())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major already exists"));
//
//            if (teacherService.findByName(request.getFullName()).isEmpty())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exists"));
//            Major major = new Major();
//            major.setMajorName(request.getMajorName());
//            major.setDepartmentId(departmentService.findByName(request.getDepartmentName()).get().getDepartmentId());
//            major.setTeacherId(teacherService.findByName(request.getFullName()).get().getTeacherId());
//            major.setCreateAt(LocalDateTime.now());
//            major.setUpdatedAt(LocalDateTime.now());
//            majorService.save(major);
//            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create major"));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//
//    @GetMapping("/admin/getAll")
//    public ResponseEntity<?> getAllMajor() {
//        try {
//            return ResponseEntity.ok(new CustomResponse<>(1, majorService.findAllForView(), null));
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//
//    @PutMapping("/admin/editMajor")
//    public ResponseEntity<?> editMajor(@RequestBody EditMajorRequest request) {
//        try {
//            if (majorService.findById(request.getMajorId()).isEmpty())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major is not exits"));
//            Major major = majorService.findById(request.getMajorId()).get();
//            if (request.getDepartmentName() != null) {
//                if (departmentService.findByName(request.getDepartmentName()).isEmpty())
//                    return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Department is not exits"));
//                if (!request.getDepartmentName().equals(departmentService.findById(major.getDepartmentId())))
//                    major.setDepartmentId(departmentService.findByName(request.getDepartmentName()).get().getDepartmentId());
//            }
//            if (request.getMajorName() != null) {
//                if (majorService.findByName(request.getMajorName()).isEmpty())
//                    return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major is not exits"));
//                if (!request.getMajorName().equals(majorService.findById(request.getMajorId())))
//                    major.setMajorName(request.getMajorName());
//            }
//            if (request.getTeacherName() != null) {
//                if (teacherService.findByName(request.getTeacherName()).isEmpty())
//                    return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exits"));
//                if (!request.getTeacherName().equals(teacherService.getTeacherInfor(major.getTeacherId())))
//                    major.setTeacherId(teacherService.findByName(request.getTeacherName()).get().getTeacherId());
//            }
//            major.setUpdatedAt(LocalDateTime.now());
//            majorService.save(major);
//            return ResponseEntity.ok(new CustomResponse<>(1, null, "Update success"));
//        } catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//    @DeleteMapping("/admin/deleteMajor/{majorId}")
//    public ResponseEntity<?> editDepartment(@PathVariable("majorId") int majorId)
//    {
//        try
//        {
//            if (majorService.findById(majorId).isEmpty())
//                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major is not exits"));
//            majorService.deleteById(majorId);
//            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success delete"));
//        }catch (Exception e) {
//            e.printStackTrace();
//            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
//        }
//    }
//}
//
//
