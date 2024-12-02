package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.custom.result.handle.ResultHandle;

import Haui.ITFacultyLearningManagement.entities.Result;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository extends JpaRepository<Result,Integer> {
    @Query(value = """
            select c.course_name as courseName, r.point
            from tb_course c
            inner join tb_course_registration r on c.course_id = r.course_id
            where r.student_id = :studentId
            """,nativeQuery = true)
    List<ResultHandle> getResult(@Param("studentId") int studentId);
}
