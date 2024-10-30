package Haui.ITFacultyLearningManagement.repository;

import Haui.ITFacultyLearningManagement.custom.classroom.handle.ClassroomViewHandle;
import Haui.ITFacultyLearningManagement.entities.Classroom;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository

public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
    @Query(value = """
            SELECT * FROM tb_classrooms WHERE className = ?1 LIMIT 1
            """, nativeQuery = true)
    Optional<Classroom> findByName(String className);

    @Query(value="""
            select c.id,c.className,c.quantity,m.majorName,i.fullName,i.phoneNumber,c.createTime,c.updateTime
            from tb_class c
            left join tb_majors m on c.majorID=m.majorID
            left join tb_teachers t on c.teacherID=t.teacherID
            left join tb_infos i on t.infoID=i.infoID
            where unaccent(c.className) ILIKE ?1
            """,nativeQuery = true)
    List<ClassroomViewHandle> getClassroomsPageable(String keySearch, Pageable pageable);

    @Query(value = """
            SELECT COUNT(*) AS total
            FROM (
            select c.id,c.className,c.quantity,m.majorName,i.fullName,i.phoneNumber,c.createTime,c.updateTime
            from tb_class c
            left join tb_majors m on c.majorID=m.majorID
            left join tb_teachers t on c.teacherID=t.teacherID
            left join tb_infos i on t.infoID=i.infoID
            where unaccent(c.className) ILIKE ?1
            ) as foo
            """,nativeQuery = true)
    Integer getTotalClassroomsPageable(String keySearch);
}
