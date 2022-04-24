package pwr.edu.rehabapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ExercisePerformed {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Exercise exercise;
    private String feedback;
    @ManyToOne
    private PatientExerciseSet patientExerciseSet;

    public ExercisePerformed(Exercise exercise, String feedback) {
        this.exercise = exercise;
        this.feedback = feedback;
    }


}
