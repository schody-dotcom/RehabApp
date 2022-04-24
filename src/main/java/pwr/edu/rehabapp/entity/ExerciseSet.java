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
public class ExerciseSet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    @OneToMany
    private List<Exercise> exercises;
    @ManyToOne
    private Doctor doctor;


    public ExerciseSet(String name, List<Exercise> exercises, Doctor doctor) {
        this.name = name;
        this.exercises = exercises;
        this.doctor = doctor;
    }


}
