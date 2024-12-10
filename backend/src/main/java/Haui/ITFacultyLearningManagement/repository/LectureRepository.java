package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.Info;
import Haui.ITFacultyLearningManagement.entities.Lecture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LectureRepository extends JpaRepository<Lecture,Integer> {
    @Query(value = """
            SELECT * FROM tb_lecture t
            LEFT OUTER JOIN tb_info i on t.infoId = i.infoId
            WHERE  full_name= ?1 LIMIT 1
            """, nativeQuery = true)
    Optional<Lecture> findByName(String name);

    @Query(value = "SELECT * FROM tb_lecture t LEFT OUTER JOIN infos i on t.infoId = i.infoId WHERE  lecture_id= ?1 LIMIT 1", nativeQuery = true)
    Optional<Info> getTeacherInfo(int id);

    @Query(value = """
            select * from tb_lecture where account_id =:accountId limit 1
            """,nativeQuery = true)
    Optional<Lecture> findByAccountId(@Param("accountId") int accountId);

    @Query(value = """
            select count(lecture_id) from tb_lecture
            """,nativeQuery = true)
    int countLecture();
}
