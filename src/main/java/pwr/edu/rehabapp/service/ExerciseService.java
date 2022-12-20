package pwr.edu.rehabapp.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.dto.ExerciseDetailsDto;
import pwr.edu.rehabapp.dto.ExerciseDto;
import pwr.edu.rehabapp.entity.Exercise;
import pwr.edu.rehabapp.entity.ExerciseSet;
import pwr.edu.rehabapp.repository.ExerciseRepo;
import pwr.edu.rehabapp.repository.ExerciseSetRepo;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ExerciseService {


    private final ExerciseRepo exerciseRepo;
    private final ExerciseSetRepo exerciseSetRepo;
    private static final ModelMapper mapper = new ModelMapper();

    private List<ExerciseDto> mapToExerciseDtoList(List<Exercise> exercises) {
        return exercises.stream()
                .map(ex -> mapper.map(ex, ExerciseDto.class))
                .collect(Collectors.toList());
    }

    public List<ExerciseDetailsDto> findAll() {
        List<Exercise> exercises = exerciseRepo.findAll();

        return mapToExerciseDetailsDtoList(exercises);
    }

    public ExerciseDetailsDto findByName(String name) {
        Exercise exercise = exerciseRepo.findByName(name);
        if (exercise == null) {
            return null;
        }
        return new ModelMapper().map(exercise, ExerciseDetailsDto.class);
    }

    public ExerciseDetailsDto save(ExerciseDetailsDto exerciseDetailsDto) {
        Exercise exercise = new ModelMapper().map(exerciseDetailsDto, Exercise.class);
        Exercise savedExercise = exerciseRepo.save(exercise);
        return mapToExerciseDetailsDto(savedExercise);
    }


    public List<ExerciseDto> findExercisesByExerciseSetNumber(long exerciseSetNumber) {
        ExerciseSet exerciseSet = exerciseSetRepo.findByNumber(exerciseSetNumber);
        if (exerciseSet == null) {
            log.error("ExerciseService: findExercisesByExerciseSetNumber(): exerciseSet with number {} not found",
                    exerciseSetNumber);
            return null;
        }
        List<Exercise> exercises = exerciseSet.getExercises();

        return mapToExerciseDtoList(exercises);
    }

    public List<ExerciseDetailsDto> mapToExerciseDetailsDtoList(List<Exercise> exercises) {
        return exercises.stream()
                .map(this::mapToExerciseDetailsDto)
                .collect(Collectors.toList());
    }



    public ExerciseDetailsDto mapToExerciseDetailsDto(Exercise exercise) {
        ExerciseDetailsDto exerciseDto = mapper.map(exercise, ExerciseDetailsDto.class);
        exerciseDto.setTypes(exercise.getFeatures().stream().map(feature -> feature.getType().toString()).toList());
        exerciseDto.setTargets(exercise.getTraits().stream().map(trait -> trait.getTarget().toString()).toList());
        return exerciseDto;
    }
}
