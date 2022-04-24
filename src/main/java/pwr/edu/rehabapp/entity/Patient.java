package pwr.edu.rehabapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient extends User {


    @Id
    private Long id;

    private int height;
    private int weight;
    private String disease;
    @OneToMany
    private List<ExerciseSet> sets;
    @OneToMany
    private List<Contact> contacts;
    @ManyToOne
    private Doctor doctor;

    public Patient(String role, Account account, boolean isOnline, List<Contact> contacts, String name, String username, int height, int weight, String disease, List<ExerciseSet> sets) {
        super(role, account, isOnline, contacts, name, username);
        this.height = height;
        this.weight = weight;
        this.disease = disease;
        this.sets = sets;
    }


}
