package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.custom.student.handle.SearchStudentHandle;
import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = """
            select i.full_name as fullName, i.date_of_birth as dateOfBirht, i.gender, i.address,  i.phone_number as phoneNumber, i.email, s.gpa
            from tb_student s left join tb_info i on i.info_id = s.info_id
            WHERE unaccent(i.full_name) ILIKE  %:keySearch%
            """,nativeQuery = true)
    List<SearchStudentHandle> getStudentWithSearch(@Param("keySearch") String keySearch, Pageable pageable);

    @Query(value = """
            select count(s.student_id)
            from tb_student s left join tb_info i on i.info_id = s.info_id
            WHERE unaccent(i.full_name) ILIKE  %:keySearch%
            """,nativeQuery = true)
    Integer getTotal(@Param("keySearch") String keySearch);

}
