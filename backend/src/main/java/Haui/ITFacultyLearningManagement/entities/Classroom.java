package Haui.ITFacultyLearningManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_class")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer classID;
    private String className;
    private Integer quantity;
    private Integer majorID;
    private Integer teacherID;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
