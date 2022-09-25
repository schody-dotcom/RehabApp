package pwr.edu.rehabapp.repository;

import lombok.AllArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pwr.edu.rehabapp.model.entity.*;
import pwr.edu.rehabapp.model.enums.Role;
import pwr.edu.rehabapp.model.enums.exerciseset.Difficulty;
import pwr.edu.rehabapp.model.enums.exerciseset.Target;
import pwr.edu.rehabapp.model.enums.exerciseset.Type;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;




@Component
@AllArgsConstructor
public class MockData {

    private UserRepo userRepo;
    private ExerciseRepo exerciseRepo;
    private ExerciseSetRepo exerciseSetRepo;
    private AppointmentRepo appointmentRepo;



    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        addAdmin();
        Doctor doctor = addDoctor();
        Patient patient = addPatient();
        List<Exercise> exercises1 = addExercises1();
        List<Exercise> exercises2 = addExercises2();
        addExerciseSet1(patient, doctor, exercises1);
        addExerciseSet2(patient, doctor, exercises2);

    }

    private void addExerciseSet1(Patient patient, Doctor doctor, List<Exercise> exercises) {
         exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(1)
                        .name("set pierwszy")
                        .difficulty(Difficulty.EASY)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );

    }

    private void addExerciseSet2(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(2)
                        .name("set drugi")
                        .difficulty(Difficulty.MEDIUM)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addAdmin() {
        userRepo.save(
                User.builder()
                        .role(Role.ADMIN)
                        .account(
                                Account.builder()
                                        .email("admin@rehab.pl")
                                        .password("123")
                                        .build()
                        )
                        .isOnline(true)
                        .name("Dominik")
                        .username("Fęsik")
                        .number(101011L)
                        .build()
        );
    }

    private Doctor addDoctor() {
        return userRepo.save(
                Doctor.doctorBuilder()
                        .role(Role.DOCTOR)
                        .account(
                                Account.builder()
                                        .email("doc1@rehab.pl")
                                        .password("123")
                                        .build()
                        )
                        .isOnline(true)
                        .name("Tomasz")
                        .username("Jałowy")
                        .number(850303549187L)
                        .build()
        );
    }

    private Patient addPatient() {
        return userRepo.save(
                Patient.patientBuilder()
                        .role(Role.PATIENT)
                        .account(
                                Account.builder()
                                        .email("patient1@rehab.pl")
                                        .password("123")
                                        .build()
                        )
                        .isOnline(true)
                        .name("Anna")
                        .username("Koala")
                        .number(94012129835L)
                        .weight(50)
                        .disease("scoliosis")
                        .height(167)
                        .build()
        );
    }

    private List<Exercise> addExercises1() {
        Exercise exercise1 = exerciseRepo.save(
                Exercise.builder()
                        .name("cow-cat")
                        .description(" ")
                        .image(" ")
                        .reps(7)
                        .target(EnumSet.of(Target.MIDDLE))
                        .type(EnumSet.of(Type.STRETCH, Type.MASSAGE))
                        .build()
        );
        Exercise exercise2 = exerciseRepo.save(
                Exercise.builder()
                        .name("squat")
                        .description(" ")
                        .image(" ")
                        .reps(8)
                        .target(EnumSet.of(Target.LOWER))
                        .type(EnumSet.of(Type.ISOMETRIC))
                        .build()
        );
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise1);
        exercises.add(exercise2);
        return exercises;
    }

    private List<Exercise> addExercises2() {
        Exercise exercise1 = exerciseRepo.save(
                Exercise.builder()
                        .name("rows")
                        .description(" ")
                        .image(" ")
                        .reps(10)
                        .target(EnumSet.of(Target.LATERAL, Target.MIDDLE))
                        .type(EnumSet.of(Type.ISOMETRIC))
                        .build()
        );
        Exercise exercise2 = exerciseRepo.save(
                Exercise.builder()
                        .name("pull up")
                        .description(" ")
                        .image(" ")
                        .reps(4)
                        .target(EnumSet.of(Target.LATERAL, Target.MIDDLE))
                        .type(EnumSet.of(Type.ISOMETRIC, Type.STRETCH))
                        .build()
        );
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise1);
        exercises.add(exercise2);
        return exercises;
    }
}
