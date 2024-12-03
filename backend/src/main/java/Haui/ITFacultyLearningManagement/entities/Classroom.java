package Haui.ITFacultyLearningManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="tb_classroom")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "class_id")
    private Integer classId;
    @Column(name = "current_student")
    private Integer currentStudent;
    @Column(name = "maximum_student")
    private Integer maximumStudent;
    @Column(name = "teacher_id")
    private Integer teacherId;
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "semester_id")
    private Integer semesterId;
    @Column(name = "status")
    private Integer status;
    @Column(name = "create_time")
    private LocalDateTime createTime;
    @Column(name = "update_time")
    private LocalDateTime updateTime;

    public Classroom(Integer maximumStudent, Integer teacherId, Integer courseId, Integer semesterId) {
        this.maximumStudent = maximumStudent;
        this.teacherId = teacherId;
        this.courseId = courseId;
        this.semesterId = semesterId;
        this.status = 1;
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.currentStudent = 0;
    }
}
