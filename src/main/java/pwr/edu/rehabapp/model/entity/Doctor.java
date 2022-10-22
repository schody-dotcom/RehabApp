package pwr.edu.rehabapp.model.entity;

import lombok.*;
import pwr.edu.rehabapp.model.enums.Role;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Doctor extends User {

    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

    @OneToMany(mappedBy = "author")
    private List<ExerciseSet> exerciseSets;

    @Builder(builderMethodName = "doctorBuilder")
    public Doctor(Long id, Account account,
                   boolean isOnline,
                  String name, String username,
                  long number, List<Patient> patients,
                  List<Appointment> appointments,
                  List<ExerciseSet> exerciseSets,
                  List<ExerciseSetPerformed> exerciseSetsPerformed) {
        super(id, account, isOnline, name, username, number);
        this.patients = patients;
        this.appointments = appointments;
        this.exerciseSets = exerciseSets;

    }
}
