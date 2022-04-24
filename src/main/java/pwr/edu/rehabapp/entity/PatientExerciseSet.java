package pwr.edu.rehabapp.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
public class PatientExerciseSet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    private ExerciseSet exerciseSet;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    @OneToOne
    private Doctor doctor;
    @OneToMany
    private List<ExercisePerformed> feedbacks;

    @ManyToOne
    private Patient patient;

    public PatientExerciseSet(ExerciseSet exerciseSet, LocalDateTime startDate, LocalDateTime endDate, Doctor doctor, List<ExercisePerformed> feedbacks) {
        this.exerciseSet = exerciseSet;
        this.startDate = startDate;
        this.endDate = endDate;
        this.doctor = doctor;
        this.feedbacks = feedbacks;
    }


}
