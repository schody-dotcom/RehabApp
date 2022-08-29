package pwr.edu.rehabapp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pwr.edu.rehabapp.model.enums.Role;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Patient extends User {


    @ManyToMany(mappedBy = "patients")
    private List<ExerciseSet> assignedExerciseSets;

    @OneToMany(mappedBy = "patient")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "patient")
    private List<ExerciseSetPerformed> ExerciseSetsPerformed;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private Doctor doctor;

    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate dateOfBirth;
    private int height;
    private int weight;
    private String disease;

    @Builder(builderMethodName = "patientBuilder")
    public Patient(Long id, Account account, Role role, boolean isOnline,
                   String name, String username, long number,
                   List<ExerciseSet> assignedExerciseSets,
                   List<Appointment> appointments,
                   List<ExerciseSetPerformed> exerciseSetsPerformed,
                   Doctor doctor, int height, LocalDate dateOfBirth,
                   int weight, String disease) {
        super(id, account, role, isOnline, name, username, number);
        this.assignedExerciseSets = assignedExerciseSets;
        this.appointments = appointments;
        ExerciseSetsPerformed = exerciseSetsPerformed;
        this.doctor = doctor;
        this.height = height;
        this.dateOfBirth = dateOfBirth;
        this.weight = weight;
        this.disease = disease;
    }
}
