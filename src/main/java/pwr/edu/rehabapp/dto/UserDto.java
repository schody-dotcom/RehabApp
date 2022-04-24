package pwr.edu.rehabapp.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {

    private int number;
    private String role;
    private boolean isOnline;
    private String email;
    private String password;

    private String name;
    private String username;

}
