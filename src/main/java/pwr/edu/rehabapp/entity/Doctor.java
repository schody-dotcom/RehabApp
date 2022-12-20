package pwr.edu.rehabapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Doctor extends User {

    //Jeden lekarz posiada wielu pacjentów. Jeden pacjent ma jednego lekarza
    @OneToMany(mappedBy = "doctor")
    private List<Patient> patients;

    //Jeden lekarz ma dostęp do wielu zestawów ćwiczeń. Jeden zestaw ćwiczeń może być stworzony przez jednego lekarza
    @OneToMany(mappedBy = "author")
    private List<ExerciseSet> exerciseSets;

    @OneToMany(mappedBy = "doctor")
    private List<Appointment> appointments;

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
