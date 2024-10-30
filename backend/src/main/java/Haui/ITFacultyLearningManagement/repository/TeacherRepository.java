package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
    @Query(value = """
            SELECT * FROM tb_teachers t
            LEFT OUTER JOIN tb_infos i on t.infoId=i.infoId
            WHERE  fullName= ?1 LIMIT 1
            """, nativeQuery = true)
    Optional<Teacher> findByName(String name);

    @Query(value = "SELECT * FROM teachers t LEFT OUTER JOIN infors i on t.inforId=i.inforId WHERE  teacherId= ?1 LIMIT 1", nativeQuery = true)
    Optional<Info> getTeacherInfor(int id);
}
