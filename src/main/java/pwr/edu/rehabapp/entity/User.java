package pwr.edu.rehabapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String role;
    @OneToOne
    private Account account;
    private boolean isOnline;
    @OneToMany
    private List<Contact> contacts;
    private String name;
    private String username;
    private int number;

    public User( String role, Account account, boolean isOnline, List<Contact> contacts, String name, String username) {

        this.role = role;
        this.account = account;
        this.isOnline = isOnline;
        this.contacts = contacts;
        this.name = name;
        this.username = username;
    }



}
