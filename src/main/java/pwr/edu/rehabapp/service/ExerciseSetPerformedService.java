package pwr.edu.rehabapp.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.model.dto.ExerciseSetPerformedDto;
import pwr.edu.rehabapp.model.entity.*;
import pwr.edu.rehabapp.repository.ExerciseRepo;
import pwr.edu.rehabapp.repository.ExerciseSetPerformedRepo;
import pwr.edu.rehabapp.repository.ExerciseSetRepo;
import pwr.edu.rehabapp.repository.PatientRepo;

@Service
@RequiredArgsConstructor
//PU: Przesyłanie feedbacku
public class ExerciseSetPerformedService {

    private final ExerciseSetPerformedRepo exerciseSetPerformedRepo;
    private  final ExerciseRepo exerciseRepo;
    private  final ExerciseSetRepo exerciseSetRepo;
    private  final UserService userService;
    final private PatientRepo patientRepo;
    private final ModelMapper mapper = new ModelMapper();

    public ExerciseSetPerformedDto save(ExerciseSetPerformedDto exerciseSetPerformedDto) {

        if (exerciseSetPerformedDto == null) {
            return null;
        }

        User loggedUser = userService.getLoggedUser();
        if (loggedUser == null || !(loggedUser instanceof Patient)) {
            return null;
        }

        Patient patient = patientRepo.findByNumber(loggedUser.getNumber());
        if (patient == null) {
            return null;
        }


        long exerciseSetNumber = exerciseSetPerformedDto.getExerciseSetNumber();
        ExerciseSet exerciseSet = exerciseSetRepo.findByNumber(exerciseSetNumber);
        if (exerciseSet == null) {
            return null;
        }

        ExerciseSetPerformed exerciseSetPerformed =
                new ModelMapper()
                        .map(exerciseSetPerformedDto, ExerciseSetPerformed.class);

        exerciseSetPerformed.setExerciseSet(exerciseSet);
        exerciseSetPerformed.getExercisesPerformed().forEach(this::assignExercise);
        exerciseSetPerformed.setPatient(patient); //powiązanie encji ExerciseSetPerformed z Patient

        ExerciseSetPerformed savedExerciseSetPerformed =
                exerciseSetPerformedRepo.save(exerciseSetPerformed);

        return mapper.map(savedExerciseSetPerformed, ExerciseSetPerformedDto.class);
    }



    //powiązanie encji ExercisePerformed z Exercise
    private void assignExercise(ExercisePerformed exercisePerformed) {
        String exerciseName = exercisePerformed.getExercise().getName(); //nazwa jest unikatowa
        Exercise byExerciseName = exerciseRepo.findByName(exerciseName);
        exercisePerformed.setExercise(byExerciseName);
    }




}
