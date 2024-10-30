package Haui.ITFacultyLearningManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_course_registrations")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CourseRegistration  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer courseRegistrationID;
    private Integer studentID;
    private Integer courseID;
    private double point;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
