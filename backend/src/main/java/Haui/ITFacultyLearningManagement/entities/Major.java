package Haui.ITFacultyLearningManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="tb_majors")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Major {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer majorID;
    private String majorName;
    private Integer teacherID;
}
