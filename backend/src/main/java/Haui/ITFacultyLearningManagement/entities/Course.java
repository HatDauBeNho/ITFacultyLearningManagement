package Haui.ITFacultyLearningManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_courses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer courseID;
    private Integer subjectID;
    private Integer currentStudent;
    private Integer maximumStudent;
    private Integer teacherID;
    private Integer condition;
    private Integer credit;
    private LocalDate startTime;
    private LocalDate endTime;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
