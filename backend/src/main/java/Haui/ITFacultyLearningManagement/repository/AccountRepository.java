package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account,Integer> {
    @Query(value = "select * from accounts where userName=?1",nativeQuery = true)
    Optional<Account> findAccountByUserName(String username);
}
