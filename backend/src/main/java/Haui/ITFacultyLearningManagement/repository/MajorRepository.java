package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MajorRepository extends JpaRepository<Major,Integer> {
    @Query(value = """
            SELECT * FROM tb_majors WHERE majorName = ?1 LIMIT 1
            """, nativeQuery = true)
    Optional<Major> findByName(String name);

}
