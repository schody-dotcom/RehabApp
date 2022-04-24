package pwr.edu.rehabapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Doctor extends User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany
    private List<Patient> patients;

    @OneToMany
    private List<Contact> contacts;

    @OneToMany
    private List<ExerciseSet> exerciseSets;

    public Doctor(String role, Account account, boolean isOnline, List<Contact> contacts, String name, String username, List<Patient> patients) {
        super(role, account, isOnline, contacts, name, username);
        this.patients = patients;
        this.contacts = contacts;
        this.exerciseSets = exerciseSets;
    }




}
