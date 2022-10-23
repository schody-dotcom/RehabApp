package pwr.edu.rehabapp.service;


import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.model.dto.ExerciseDetailsDto;
import pwr.edu.rehabapp.model.dto.ExerciseDto;
import pwr.edu.rehabapp.model.entity.Exercise;
import pwr.edu.rehabapp.model.entity.ExerciseSet;
import pwr.edu.rehabapp.model.enums.exerciseset.Target;
import pwr.edu.rehabapp.model.enums.exerciseset.Type;
import pwr.edu.rehabapp.repository.ExerciseRepo;
import pwr.edu.rehabapp.repository.ExerciseSetRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
public class ExerciseService {


    private final ExerciseRepo exerciseRepo;
    private final ExerciseSetRepo exerciseSetRepo;
    private static final ModelMapper mapper = new ModelMapper();

    public List<ExerciseDetailsDto> findAll() {
        List<Exercise> exercises = exerciseRepo.findAll();

        return mapToExerciseDetailsDtoList(exercises);
    }

    public ExerciseDetailsDto findByName(String name) {
        Exercise exercise = exerciseRepo.findByName(name);
        return new ModelMapper().map(exercise, ExerciseDetailsDto.class);
    }

    public ExerciseDetailsDto findByTarget(Target target) {
        Exercise exercise = exerciseRepo.findByTarget(target);
        return new ModelMapper().map(exercise, ExerciseDetailsDto.class);
    }

    public ExerciseDetailsDto findByType(Type type) {
        Exercise exercise = exerciseRepo.findByType(type);
        return new ModelMapper().map(exercise, ExerciseDetailsDto.class);
    }

    public ExerciseDetailsDto save(ExerciseDetailsDto exerciseDetailsDto) {
        Exercise exercise = new ModelMapper().map(exerciseDetailsDto, Exercise.class);
        Exercise savedExercise = exerciseRepo.save(exercise);
        return mapper.map(savedExercise, ExerciseDetailsDto.class);
    }


    public List<ExerciseDto> findExercisesByExerciseSetNumber(long exerciseSetNumber) {
        ExerciseSet exerciseSet = exerciseSetRepo.findByNumber(exerciseSetNumber);
        List<Exercise> exercises = exerciseSet.getExercises();

        return mapToExerciseDtoList(exercises);
    }

    private List<ExerciseDetailsDto> mapToExerciseDetailsDtoList(List<Exercise> exercises) {
        return exercises.stream()
                .map(ex -> mapper.map(ex, ExerciseDetailsDto.class))
                .collect(Collectors.toList());
    }
    private List<ExerciseDto> mapToExerciseDtoList(List<Exercise> exercises) {
        return exercises.stream()
                .map(ex -> mapper.map(ex, ExerciseDto.class))
                .collect(Collectors.toList());
    }
}
