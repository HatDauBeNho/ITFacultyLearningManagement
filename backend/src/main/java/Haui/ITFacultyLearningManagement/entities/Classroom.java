package Haui.ITFacultyLearningManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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
    private Integer course_id;
    @Column(name = "semester_id")
    private Integer semesterId;

}