package Haui.ITFacultyLearningManagement.custom.auth.login.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginResponse {
    @JsonProperty(value = "userName")
    private String username;
    @JsonProperty(value = "role")
    private String role;
    @JsonProperty(value = "status")
    private int status;

}
