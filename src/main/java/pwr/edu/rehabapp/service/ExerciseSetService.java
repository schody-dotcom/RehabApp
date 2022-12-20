package pwr.edu.rehabapp.service;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import pwr.edu.rehabapp.dto.ExerciseSetDto;
import pwr.edu.rehabapp.dto.request.ExerciseToExerciseSetDto;
import pwr.edu.rehabapp.entity.Exercise;
import pwr.edu.rehabapp.entity.ExerciseSet;
import pwr.edu.rehabapp.entity.Patient;
import pwr.edu.rehabapp.entity.User;
import pwr.edu.rehabapp.model.entity.*;
import pwr.edu.rehabapp.repository.*;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class ExerciseSetService {

    final private ExerciseSetRepo exerciseSetRepo;
    final private ExerciseRepo exerciseRepo;
    final private PatientRepo patientRepo;
    final private ExerciseService exerciseService;
    final private UserService userService;
    private static final ModelMapper mapper = new ModelMapper();

    //PU: Wykonywanie zestawu ćwiczeń - szukanie zestawu po jego numerze
    public ExerciseSetDto findByNumber(long number) {

        User loggedUser = userService.getLoggedUser();
        if (loggedUser == null || !(loggedUser instanceof Patient)) {
            return null;
        }

        Patient patient = patientRepo.findByNumber(loggedUser.getNumber());

        if (!patient.hasAccessToExerciseSet(number)) {
            return null;
        }
        ExerciseSet exerciseSet = exerciseSetRepo.findByNumber(number);

        ExerciseSetDto exerciseSetDto = new ModelMapper().map(exerciseSet, ExerciseSetDto.class);
        exerciseSetDto.setExercises(exerciseService.mapToExerciseDetailsDtoList(exerciseSet.getExercises()));
        return exerciseSetDto;
    }


    //PU: Przeglądanie listy zestawów ćwiczeń
    public List<ExerciseSetDto> findExerciseSetsByPatientNumber(long patientNumber) {

        Patient patient = patientRepo.findByNumber(patientNumber);
        if (patient == null) {
            return null;
        }
        List<ExerciseSetDto> sets = new ArrayList<>();
        if (!CollectionUtils.isEmpty(patient.getAssignedExerciseSets())) {
            patient.getAssignedExerciseSets()
                    .forEach(set ->
                            sets.add(map(set))
                    );
        } else
            return null;
        return sets;
    }









    public List<ExerciseSetDto> findAll() {
        List<ExerciseSet> sets = exerciseSetRepo.findAll();
        return sets
                .stream()
                .map(set -> mapper.map(set, ExerciseSetDto.class))
                .collect(Collectors.toList());
    }



    private ExerciseSetDto map(ExerciseSet set) {
        ExerciseSetDto dto = mapper.map(set, ExerciseSetDto.class);
        dto.setNumberOfExercises(set.getExercises().size());
        return dto;
    }


    public ExerciseSetDto assignExerciseToExerciseSet(ExerciseToExerciseSetDto dto) {

        ExerciseSet exerciseSet = exerciseSetRepo.findByNumber(dto.getExerciseSetNumber());
        Exercise exercise = exerciseRepo.findByName(dto.getExerciseName());
        exerciseSet.getExercises().add(exercise);
        return mapper.map(
                exerciseSet,
                ExerciseSetDto.class
        );

    }


    public ExerciseSetDto save(ExerciseSetDto dto) {
        ExerciseSet entity = mapper.map(dto, ExerciseSet.class);
        ExerciseSet savedEntity = exerciseSetRepo.save(entity);

        return mapper.map(savedEntity, ExerciseSetDto.class);
    }
}
