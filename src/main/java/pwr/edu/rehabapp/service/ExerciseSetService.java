package pwr.edu.rehabapp.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.model.dto.ExerciseSetDto;
import pwr.edu.rehabapp.model.dto.request.ExerciseToExerciseSetDto;
import pwr.edu.rehabapp.model.entity.Exercise;
import pwr.edu.rehabapp.model.entity.ExerciseSet;
import pwr.edu.rehabapp.model.entity.Patient;
import pwr.edu.rehabapp.repository.ExerciseRepo;
import pwr.edu.rehabapp.repository.ExerciseSetRepo;
import pwr.edu.rehabapp.repository.PatientRepo;

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
    private static final ModelMapper mapper = new ModelMapper();
    final private ExerciseService exerciseService;

    public List<ExerciseSetDto> findAll(){
        List<ExerciseSet> sets = exerciseSetRepo.findAll();
        return sets
                .stream()
                .map(set -> mapper.map(set, ExerciseSetDto.class))
                .collect(Collectors.toList());
    }

    public ExerciseSetDto findByNumber(long number) {
        ExerciseSet exerciseSet = exerciseSetRepo.findByNumber(number);
        return new ModelMapper().map(exerciseSet, ExerciseSetDto.class);
    }

    public List<ExerciseSetDto> findExerciseSetByPatientNumber(long patientNumber) {
        Patient patient = patientRepo.findByNumber(patientNumber);
        List<ExerciseSetDto> sets = new ArrayList<>();
        if (!patient.getAssignedExerciseSets().isEmpty()){
            patient
                    .getAssignedExerciseSets()
                    .forEach(set ->
                        sets.add(map(set))
                    );
        }
        return sets;
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
