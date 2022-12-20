package pwr.edu.rehabapp.entity;

import lombok.*;
import pwr.edu.rehabapp.entity.enums.Role;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private Role role;
    private String email;
    private String password;
}
