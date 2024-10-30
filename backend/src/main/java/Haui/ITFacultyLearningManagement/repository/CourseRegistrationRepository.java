package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.CourseRegistration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CourseRegistrationRepository extends JpaRepository<CourseRegistration,Integer> {
    @Query(value = "SELECT * FROM course_registrations WHERE courseRegistrationName = ?1 LIMIT 1", nativeQuery = true)
    Optional<CourseRegistration> findByName(String name);

    @Query(value = "select * from course_registrations where studentId=?1",nativeQuery = true)
    List<CourseRegistration> findByStudentId(Integer studentId);
}
