package pwr.edu.rehabapp.repository.data;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import pwr.edu.rehabapp.entity.*;
import pwr.edu.rehabapp.entity.enums.Role;
import pwr.edu.rehabapp.entity.enums.exerciseset.Difficulty;
import pwr.edu.rehabapp.entity.enums.exerciseset.Target;
import pwr.edu.rehabapp.entity.enums.exerciseset.Type;
import pwr.edu.rehabapp.repository.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;


@RequiredArgsConstructor
@Component
public class MockData {

    private final TraitRepo traitRepo;
    private final FeatureRepo featureRepo;
    private final UserRepo userRepo;
    private final ExerciseRepo exerciseRepo;
    private final ExerciseSetRepo exerciseSetRepo;

    private final PasswordEncoder passwordEncoder;

    private Trait traitLateral;
    private Trait traitLower;
    private Trait traitMiddle;
    private Trait traitNeck;

    private Feature featureIsometric;
    private Feature featureStretch;
    private Feature featureMassage;
    private Feature featureWarmup;

    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        createTraitsAndFeatures();
        addAdmin();
        Doctor doctor = addDoctor();
        Patient patient = addPatient();
        Random random = new Random();

        List<Exercise> exercises1 = addExercises1();
        List<Exercise> exercises2 = new ArrayList<>(exercises1);
        Collections.shuffle(exercises2, random);

        List<Exercise> exercises3 = new ArrayList<>(exercises1);
        Collections.shuffle(exercises3, random);

        addExerciseSet1(patient, doctor, exercises1);
        addExerciseSet2(patient, doctor, exercises2);
        addExerciseSet3(patient, doctor, exercises3);
        addExerciseSet4(patient, doctor, exercises3);
        addExerciseSet5(patient, doctor, exercises3);
        addExerciseSet6(patient, doctor, exercises3);
        addExerciseSet7(patient, doctor, exercises3);
        addExerciseSet8(patient, doctor, exercises3);
        addExerciseSet9(patient, doctor, exercises3);
        addExerciseSet10(patient, doctor, exercises3);

    }


    private void addExerciseSet1(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(1)
                        .name("warmup set")
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
                        .name("back strength set")
                        .difficulty(Difficulty.MEDIUM)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet3(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(3)
                        .name("cool down set")
                        .difficulty(Difficulty.HARD)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet4(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(4)
                        .name("lower back pain")
                        .difficulty(Difficulty.HARD)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet5(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(5)
                        .name("upper back pain")
                        .difficulty(Difficulty.HARD)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet6(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(6)
                        .name("lats strengthening")
                        .difficulty(Difficulty.HARD)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet7(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(7)
                        .name("increase hip mobility")
                        .difficulty(Difficulty.MEDIUM)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet8(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(8)
                        .name("morning stretch")
                        .difficulty(Difficulty.EASY)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet9(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(9)
                        .name("do it before")
                        .difficulty(Difficulty.MEDIUM)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addExerciseSet10(Patient patient, Doctor doctor, List<Exercise> exercises) {
        exerciseSetRepo.save(
                ExerciseSet.builder()
                        .number(10)
                        .name("neck pain relief")
                        .difficulty(Difficulty.EASY)
                        .patients(List.of(patient))
                        .author(doctor)
                        .exercises(exercises)
                        .build()
        );
    }

    private void addAdmin() {
        userRepo.save(
                User.builder()
                        .account(
                                Account.builder()
                                        .role(Role.ROLE_ADMIN)
                                        .email("admin@rehab.pl")
                                        .password(passwordEncoder.encode("123"))
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
                        .account(
                                Account.builder()
                                        .role(Role.ROLE_DOCTOR)
                                        .email("doc1@rehab.pl")
                                        .password(passwordEncoder.encode("123"))
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
                        .account(
                                Account.builder()
                                        .role(Role.ROLE_PATIENT)
                                        .email("patient1@rehab.pl")
                                        .password(passwordEncoder.encode("123"))
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
                        .name("pelvic tilts")
                        .description("Lie on your back with knees bent, feet flat on floor. Tighten your stomach by contracting it as though you were preparing for a punch. You’ll feel your back pressing into the floor, and your hips and pelvis rocking back. Hold for 10 seconds while breathing in and out smoothly. Repeat 10 times.")
                        .image("https://i.imgur.com/yWhuhQl.gif")
                        .reps(10)
                        .traits(List.of(traitLower, traitMiddle))
                        .features(List.of(featureIsometric))
                        .build()
        );
        Exercise exercise2 = exerciseRepo.save(
                Exercise.builder()
                        .name("rotational stretch")
                        .description("Sit on an armless chair or a stool. Cross your right leg over your left leg. Bracing your left elbow against the outside of your right knee, twist and stretch to the side . Hold for 10 seconds. Repeat on the opposite side. Repeat this stretch 3 times on each side.")
                        .image("https://i.imgur.com/so1B4tH.gif")
                        .reps(3)
                        .traits(List.of(traitLateral, traitNeck))
                        .features(List.of(featureStretch, featureWarmup, featureMassage))
                        .build()
        );
        Exercise exercise3 = exerciseRepo.save(
                Exercise.builder()
                        .name("flat back")
                        .description("Stand facing a desk or counter with your hands on the surface. Keeping hands on the surface, slowly walk feet away from the desk/table/counter until you can hinge forward at the hips and form an \"L\" with your body: Legs should be straight (with slight bend—no locking the knees); back should be flat and parallel to the floor; and arms should be straight with hands placed on the counter surface. Hold for 15 to 30 seconds and repeat 3 times.")
                        .image("https://i.imgur.com/TbbvMe2.png")
                        .reps(3)
                        .traits(List.of(traitLower, traitMiddle))
                        .features(List.of(featureStretch, featureWarmup))
                        .build()
        );
        Exercise exercise4 = exerciseRepo.save(
                Exercise.builder()
                        .name("bridging")
                        .description("Lie on your back with knees bent and just your heels on the floor. Push your heels into the floor, squeeze your buttocks, and lift your hips off the floor until shoulders, hips, and knees are in a straight line. Hold about 6 seconds, and then slowly lower hips to the floor and rest for 10 seconds. Repeat 9 times. Avoid arching your lower back as your hips move upward. Avoid overarching by tightening your abdominal muscles prior and throughout the lift.")
                        .image("https://i.imgur.com/LStrUWZ.png")
                        .reps(9)
                        .traits(List.of(traitLower, traitMiddle))
                        .features(List.of(featureIsometric))
                        .build()
        );
        Exercise exercise5 = exerciseRepo.save(
                Exercise.builder()
                        .name("bird-dog")
                        .description("Start on your hands and knees, and tighten your stomach muscles. Lift and extend one leg behind you. Keep hips level. Hold for 5 seconds, and then switch to the other leg. Repeat 8 times for each leg, and try to lengthen the time you hold each lift. Try lifting and extending your opposite arm for each repetition. This exercise is a great way to learn how to stabilize the low back during movement of the arms and legs. While doing this exercise don't let the lower back muscles sag. Only raise the limbs to heights where the low back position can be maintained.")
                        .image("https://i.imgur.com/OaW0byf.gif")
                        .reps(8)
                        .traits(List.of(traitLateral, traitMiddle, traitLower))
                        .features(List.of(featureIsometric, featureStretch, featureWarmup))
                        .build()
        );
        Exercise exercise6 = exerciseRepo.save(
                Exercise.builder()
                        .name("dead hang")
                        .description("Use a secure overhead bar. Use a step or bench so you can easily reach the bar with your arms. You don’t want to jump straight into a dead hang.Grip the bar with an overhand grip (palms facing away from you). Aim to keep your arms shoulder-width apart.\n" +
                                "Move your feet off the step or bench so you’re hanging on to the bar. Keep your arms straight. Don’t bend your arms and stay relaxed. Hang for 10 seconds if you’re new to the exercise. Work your way up to 45 seconds to 1 minute at a time. Slowly step back onto the step or bench before releasing your arms. Repeat up to 3 times, if you wish.")
                        .image("https://i.imgur.com/kjYfv49.png")
                        .reps(3)
                        .traits(List.of(traitLateral, traitNeck, traitMiddle))
                        .features(List.of(featureIsometric, featureStretch))
                        .build()
        );
        Exercise exercise7 = exerciseRepo.save(
                Exercise.builder()
                        .name("ear to shoulder")
                        .description("Sit on the floor with your legs crossed and lengthen the spine. Interlace your hands behind your back and bring them toward your right hip. As you exhale gently drop your right ear toward your right shoulder. Stay in easy pose with ear to shoulder stretch for 30 seconds, switch sides, and repeat the whole process 3 times.")
                        .image("https://i.imgur.com/tInhNsq.gif")
                        .reps(4)
                        .traits(List.of(traitNeck, traitLateral))
                        .features(List.of(featureMassage, featureWarmup, featureStretch))
                        .build()
        );
        Exercise exercise8 = exerciseRepo.save(
                Exercise.builder()
                        .name("knee to chest")
                        .description("Lie on your back with knees bent and feet flat on the floor. Bring one knee to your chest, keeping the other foot flat on the floor. Keep your lower back pressed to the floor, and hold for 15 to 30 seconds. Then lower your knee and repeat with the other leg. Do this 3 times for each leg.")
                        .image("https://i.imgur.com/dNDlFQt.gif")
                        .reps(3)
                        .traits(List.of(traitLower, traitMiddle))
                        .features(List.of(featureStretch, featureWarmup))
                        .build()
        );
        Exercise exercise9 = exerciseRepo.save(
                Exercise.builder()
                        .name("cow cat pose")
                        .description("Kneel on the floor and put your hands on the floor in front of you. Keep your hands shoulder-width apart and your knees directly below your hips. Inhale deeply while curving your lower back and bringing your head up, tilting your pelvis up like a \"cow.\" Exhale deeply and bring your abdomen in, arching your spine and bringing your head and pelvis down like a cat. Repeat 7 times.")
                        .image("https://i.imgur.com/reTETjV.gif")
                        .reps(7)
                        .traits(List.of(traitNeck, traitMiddle))
                        .features(List.of(featureWarmup, featureStretch, featureMassage))
                        .build()
        );
        Exercise exercise10 = exerciseRepo.save(
                Exercise.builder()
                        .name("squat")
                        .description("Stand up with your feet shoulder-width apart. Bend your knees, press your hips back and stop the movement once the hip joint is slightly lower than the knees. Press your heels into the floor to return to the initial position. Repeat 15 times.")
                        .image("https://i.imgur.com/EbAjdCw.gif")
                        .reps(15)
                        .traits(List.of(traitLower, traitMiddle))
                        .features(List.of(featureIsometric))
                        .build()
        );
        List<Exercise> exercises = new ArrayList<>();
        exercises.add(exercise10);
        exercises.add(exercise9);
        exercises.add(exercise8);
        exercises.add(exercise7);
        exercises.add(exercise6);
        exercises.add(exercise5);
        exercises.add(exercise4);
        exercises.add(exercise3);
        exercises.add(exercise2);
        exercises.add(exercise1);
        return exercises;
    }


    private void createTraitsAndFeatures() {
        traitLateral = saveTrait(Target.LATERAL);
        traitLower = saveTrait(Target.LOWER);
        traitMiddle = saveTrait(Target.MIDDLE);
        traitNeck = saveTrait(Target.NECK);

        featureIsometric = saveFeature(Type.ISOMETRIC);
        featureStretch = saveFeature(Type.STRETCH);
        featureMassage = saveFeature(Type.MASSAGE);
        featureWarmup = saveFeature(Type.WARMUP);
    }

    private Trait saveTrait(Target target) {

        return traitRepo.save(Trait.builder().target(target).build());
    }

    private Feature saveFeature(Type type) {

        return featureRepo.save(Feature.builder().type(type).build());
    }
}
