package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.custom.course.handle.ListCourseHandle;
import Haui.ITFacultyLearningManagement.custom.course.handle.CurrentTaughtHandle;
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
            select c.course_name as courseName, c.current_student as currentStudent, i.full_name as fullName, c.credit
            from tb_course c
            left join tb_teacher t on c.teacher_id = t.teacher_id
            left join tb_info i on i.info_id = t.info_id
            WHERE unaccent(c.course_name) ILIKE  %:keySearch%
            """,nativeQuery = true)
    List<ListCourseHandle> getAllCourse(@Param("keySearch") String keySearch, Pageable pageable);

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
}
