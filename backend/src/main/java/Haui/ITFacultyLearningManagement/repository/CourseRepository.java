package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.custom.subject.handle.ListSubjectHandle;
import Haui.ITFacultyLearningManagement.custom.course.handle.CurrentTaughtHandle;
import Haui.ITFacultyLearningManagement.custom.course.handle.ListStudentInCourseHandle;
import Haui.ITFacultyLearningManagement.entities.Course;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course,Integer> {
    @Query(value = """
            select course_name as courseName, credit, create_time as createTime
            from tb_course c
            WHERE unaccent(c.course_name) ILIKE  %:keySearch%
            """,nativeQuery = true)
    List<ListSubjectHandle> getCourseBySearch(@Param("keySearch") String keySearch, Pageable pageable);

    @Query(value = """
            select count(course_name)
            from tb_course
            WHERE unaccent(course_name) ILIKE  %:keySearch%
            """, nativeQuery = true)
    Integer totalAllCourse(@Param("keySearch") String keySearch);

    @Query(value = """
            select * from tb_course where course_name = ?1 limit 1
            """,nativeQuery = true)
    Optional<Course> findByCourseName(String courseName);

    @Query(value = """
            select course_id as courseId, course_name as courseName, current_student as currentStudent,
                start_time as startTime, end_time as endTime
            from tb_course where teacher_id = :teacherId
            """,nativeQuery = true)
    List<CurrentTaughtHandle> getCurrentTaught(@Param("teacherId") int teacherId, Pageable pageable);

    @Query(value = """
            select count(course_id)
            from tb_course where teacher_id = :teacherId
            """, nativeQuery = true)
    int getTotalCurrentTaught(@Param("teacherId") int teacherId);

    @Query(value = """
            select i.full_name as fullName, s.student_id as studentId, c.point , i.phone_number as phoneNumber
            from tb_course c
            left join tb_classroom cr on c.course_id = cr.course_id
            left join tb_course_registration r r.class_id = cr.class_id
            left join tb_student s on cr.student_id = s.student_id
            left join tb_info i on s.info_id = i.info_id
            where unaccent(i.full_name) ILIKE  %:keySearch%
            """,nativeQuery = true)
    List<ListStudentInCourseHandle> getListStuInClass(@Param("keySearch") String keySearch,
                                                       @Param("teacherId") int teacherId,
                                                       Pageable pageable);

    @Query(value = """
            select count(s.student_id)
            from tb_course c
            left join tb_classroom cr on c.course_id = cr.course_id
            left join tb_course_registration r r.class_id = cr.class_id
            inner join tb_student s on cr.student_id = s.student_id
            inner join tb_info i on s.info_id = i.info_id
            where unaccent(i.full_name) ILIKE  %:keySearch% and c.teacher_id = :teacherId
            """,nativeQuery = true)
    int getTotalListStuInCourse(@Param("keySearch") String keySearch,
                                @Param("teacherId") int teacherId);
}
