package Haui.ITFacultyLearningManagement.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_students")
@NoArgsConstructor
@AllArgsConstructor
public class Student  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer studentID;
    private Integer accountID;
    private Integer infoID;
    private Integer classID;
    private double gpa;
    private Integer status;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
