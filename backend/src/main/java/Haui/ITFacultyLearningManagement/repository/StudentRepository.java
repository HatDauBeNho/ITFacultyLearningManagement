package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    @Query(value = "SELECT * FROM students t LEFT OUTER JOIN infors i on t.inforId=i.inforId WHERE  fullName= ?1 LIMIT 1", nativeQuery = true)
    Optional<Student> findByName(String name);

    @Query(value = "SELECT * FROM students t LEFT OUTER JOIN infors i on t.inforId=i.inforId WHERE  studentId= ?1 LIMIT 1", nativeQuery = true)
    Optional<Info> getStudentInfor(int id);
}
