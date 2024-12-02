package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.custom.result.handle.ResultHandle;
import org.hibernate.validator.constraints.ParameterScriptAssert;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ResultRepository {
    @Query(value = """
            select c.course_name as courseName, r.point
            from tb_course c
            inner join tb_course_registration r on c.course_id = r.course_id
            where r.student_id = :studentId
            """,nativeQuery = true)
    List<ResultHandle> getResult(@Param("studentId") int studentId);
}
