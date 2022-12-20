package pwr.edu.rehabapp.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import pwr.edu.rehabapp.entity.enums.exerciseset.Difficulty;

import javax.persistence.*;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseSet {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonIgnore
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "exercise_set_exercise",
            joinColumns = @JoinColumn(name = "exercise_set_id"),
            inverseJoinColumns = @JoinColumn(name = "exercise_id")
    )
    private List<Exercise> exercises;

    @ManyToOne
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor author;


    //Jeden zestaw ćwiczeń może być przypisany do wielu pacjentów. Wielu pacjentów może mieć przypisany
    // ten sam zestaw ćwiczeń
    @ManyToMany
    @JoinTable(
            name = "exercise_set_patient",
            joinColumns = @JoinColumn(name = "exercise_set_id"),
            inverseJoinColumns = @JoinColumn(name = "patient_id")
    )
    private List<Patient> patients;

    //Jeden zestaw ćwiczeń może być wykonywany wiele razy.
    @OneToMany(mappedBy = "exerciseSet")
    private List<ExerciseSetPerformed> exerciseSetsPerformed;

    private String name;
    private long number;

    @Enumerated(EnumType.STRING)
    private Difficulty difficulty;



    public void addExercise(Exercise exercise){
        this.exercises.add(exercise);
    }
}
