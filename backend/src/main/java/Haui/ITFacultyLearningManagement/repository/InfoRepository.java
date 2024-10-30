package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.Info;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InfoRepository extends JpaRepository<Info,Integer> {
    @Query(value = "SELECT * FROM infors WHERE fullName = ?1 LIMIT 1", nativeQuery = true)
    Optional<Info> findByName(String name);

    @Query(value = "select * from infors where phoneNumber=?1 limit 1",nativeQuery = true)
    Optional<Info> findByPhoneNumber(String phoneNumber);
}
