package pwr.edu.rehabapp.model.entity;


import lombok.*;
import pwr.edu.rehabapp.model.enums.Role;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(
            optional = false,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "account_id", referencedColumnName = "id")
    private Account account;

    @Enumerated(EnumType.STRING)
    private Role role;
    private boolean isOnline;
    private String name;
    private String username;
    private long number;
}
