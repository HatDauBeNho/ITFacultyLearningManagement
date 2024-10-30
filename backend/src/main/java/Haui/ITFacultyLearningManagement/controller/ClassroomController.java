package Haui.ITFacultyLearningManagement.controller;


import Haui.ITFacultyLearningManagement.custom.classroom.request.CreateClassroomRequest;
import Haui.ITFacultyLearningManagement.custom.classroom.request.EditClassroomRequest;
import Haui.ITFacultyLearningManagement.custom.data.reponse.CustomResponse;
import Haui.ITFacultyLearningManagement.entities.Classroom;
import Haui.ITFacultyLearningManagement.entities.Major;
import Haui.ITFacultyLearningManagement.entities.Teacher;
import Haui.ITFacultyLearningManagement.service.ClassroomService;
import Haui.ITFacultyLearningManagement.service.MajorService;
import Haui.ITFacultyLearningManagement.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.time.LocalDateTime;
import java.util.Optional;

@RestController
@RequestMapping("/classroom")
public class ClassroomController {
    @Autowired
    private ClassroomService classroomService;

    @Autowired
    private MajorService majorService;

    @Autowired
    private TeacherService teacherService;

    @PostMapping("/createClassroom")
    public ResponseEntity<?> createClassroom(@RequestBody CreateClassroomRequest request)
    {
        try {
            if (classroomService.findByName(request.getClassName()).isPresent())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Classroom already exists"));
            if (majorService.findByName(request.getMajorName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major is not exists"));
            if (teacherService.findByName(request.getFullName()).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exists"));

            Classroom classroom=new Classroom();
            classroom.setClassName(request.getClassName());
            classroom.setQuantity(request.getQuantity());
            classroom.setMajorID(majorService.findByName(request.getMajorName()).get().getMajorID());
            classroom.setTeacherID(teacherService.findByName(request.getFullName()).get().getTeacherID());
            classroom.setCreateTime(LocalDateTime.now());
            classroom.setUpdateTime(LocalDateTime.now());
            classroomService.save(classroom);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Success create class"));

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @GetMapping("/pageable")
    public ResponseEntity<?> getClassroomsPageable(@RequestParam("keySearch")String keySearch, Pageable pageable){
        try
        {
            return ResponseEntity.ok(new CustomResponse<>(1, classroomService.getClassroomsPageable(keySearch,pageable), null));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @PutMapping("/editClassroom")
    public ResponseEntity<?> editClassroom (@RequestBody EditClassroomRequest request)
    {
        try
        {
            Optional<Classroom> classroomOptional=classroomService.findById(request.getClassId());
            if (classroomOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Class is not exits"));
            Classroom classroom=classroomOptional.get();

            if (classroomService.findByName(request.getClassName()).isPresent())
            {
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Class name is exits"));
            }
            classroom.setClassName(request.getClassName());

            if (request.getQuantity()>70)
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Quantity is not invalid"));
            classroom.setQuantity(request.getQuantity());

            Optional<Major> majorOptional=majorService.findByName(request.getMajorName());
            if (majorOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Major is not exits"));
            classroom.setMajorID(majorOptional.get().getMajorID());

            Optional< Teacher>teacherOptional=teacherService.findByName(request.getFullName());
            if (teacherOptional.isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Teacher is not exits"));
            classroom.setTeacherID(teacherOptional.get().getTeacherID());

            classroom.setUpdateTime(LocalDateTime.now());
            classroomService.save(classroom);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "Update success"));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }

    @DeleteMapping("/deleteClassroom")
    public ResponseEntity<?> editClassroom(@RequestParam("classId") int classId)
    {
        try
        {
            if (classroomService.findById(classId).isEmpty())
                return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, "Class is not exits"));
            classroomService.deleteById(classId);
            return ResponseEntity.ok(new CustomResponse<>(1, null, "success delete"));

        }catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().body(new CustomResponse<>(0, null, e.getMessage()));
        }
    }
}
