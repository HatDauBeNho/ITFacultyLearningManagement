package Haui.ITFacultyLearningManagement.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name="tb_infos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Info  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer infoID;
    private String fullName;
    private String address;
    private String phoneNumber;
    private String email;
    private LocalDate dateOfBirth;
    private Integer gender;
    private String avatar;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
