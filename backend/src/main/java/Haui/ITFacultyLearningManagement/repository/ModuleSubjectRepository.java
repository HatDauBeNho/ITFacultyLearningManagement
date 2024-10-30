package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ModuleSubjectRepository extends JpaRepository<Course,Integer> {
    @Query(value = "SELECT * FROM module_subjects WHERE moduleSubjectName = ?1 LIMIT 1", nativeQuery = true)
    Optional<Course> findByName(String name);
}
