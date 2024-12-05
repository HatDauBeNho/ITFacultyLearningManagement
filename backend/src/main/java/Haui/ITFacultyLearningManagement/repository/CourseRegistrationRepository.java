package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.custom.courseRegistration.handle.RegisteredCourseHandle;
import Haui.ITFacultyLearningManagement.custom.result.handle.ResultHandle;
import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration,Integer> {
    @Query(value = "SELECT * FROM tb_course_registration WHERE course_registration_name = ?1 LIMIT 1", nativeQuery = true)
    Optional<CourseRegistration> findByName(String name);

    @Query(value = "select * from tb_course_registration where student_id=?1 and class_id=?2 limit 1", nativeQuery = true)
    Optional<CourseRegistration> findByStuAndClass(int studentId, int classId);

    @Query(value = "select * from tb_course_registration where student_id=?1",nativeQuery = true)
    List<CourseRegistration> findByStudentId(Integer studentId);

    @Query(value = """
                    select * from  tb_course_registration where course_id=?1 and student_id=?2
                    """,nativeQuery = true)
    Optional<CourseRegistration> findByStudentIdAndCourseId(int courseId,int studentId);

    @Query(value = """
            select c.course_name as "courseName", cr.current_student as "currentStudent", cr.maximum_student as "maximumStudent",
            i.full_name as "fullName",s.start_time as "startTime",s.end_time as "endTime", cr.create_time as "createTime"
            from tb_course c
            left join tb_classroom cr on c.course_id = cr.course_id
            left join tb_course_registration r on cr.class_id= r.class_id
            left join tb_semester s on s.semester_id = cr.semester_id
            left join tb_teacher t on cr.teacher_id = t.teacher_id
            left join tb_info i on t.info_id = i.info_id
            where r.student_id = :studentId
            """, nativeQuery = true)
    List<RegisteredCourseHandle> getRegisteredCourse(@Param("studentId") int studentId);

    @Query(value = """
            select count(c.course_name)
            from tb_course c
            inner join tb_course_registration r on c.course_id = r.course_id
            inner join tb_teacher t on c.teacher_id = t.teacher_id
            inner join tb_info i on t.info_id = i.info_id
            where r.student_id = :studentId
            """,nativeQuery = true)
    Integer getTotal(@Param("studentId") int studentId);

    @Query(value = """
            select *  from tb_course_registration where course_id=:courseId
            """,nativeQuery = true)
    Optional<CourseRegistration> findByCourseId(@Param("courseId") int courseId);

    @Query(value = """
            select c.course_name as courseName, r.point
            from tb_course c
            inner join tb_course_registration r on c.course_id = r.course_id
            where r.student_id = :studentId
            """,nativeQuery = true)
    List<ResultHandle> getResult(@Param("studentId") int studentId);
}
