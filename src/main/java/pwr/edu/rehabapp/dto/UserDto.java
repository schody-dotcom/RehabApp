package pwr.edu.rehabapp.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Serializable {

    private long number;
    private boolean isOnline;
    private String email;
    private String password;
    private String name;
    private String username;
    private String role;

}
