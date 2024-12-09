package Haui.ITFacultyLearningManagement.custom.lecture.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherResponse {
    private int teacherId;
    private String fullName;
    private LocalDate dateOfBirth;
    private int gender;
    private String address;
    private String phoneNumber;
    private String email;
}
