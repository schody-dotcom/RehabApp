package pwr.edu.rehabapp.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.model.dto.ExerciseSetPerformedDto;
import pwr.edu.rehabapp.model.entity.Exercise;
import pwr.edu.rehabapp.model.entity.ExercisePerformed;
import pwr.edu.rehabapp.model.entity.ExerciseSet;
import pwr.edu.rehabapp.model.entity.ExerciseSetPerformed;
import pwr.edu.rehabapp.repository.ExerciseRepo;
import pwr.edu.rehabapp.repository.ExerciseSetPerformedRepo;
import pwr.edu.rehabapp.repository.ExerciseSetRepo;

@Service
@RequiredArgsConstructor
public class ExerciseSetPerformedService {

    private final ExerciseSetPerformedRepo exerciseSetPerformedRepo;
    private  final ExerciseRepo exerciseRepo;
    private  final ExerciseSetRepo exerciseSetRepo;
    private final ModelMapper mapper = new ModelMapper();

    public ExerciseSetPerformedDto save(ExerciseSetPerformedDto exerciseSetPerformedDto) {

        if (!exerciseSetRepo.existsByNumber(exerciseSetPerformedDto.getExerciseSetNumber())) {
            return null;
        }

        ExerciseSetPerformed exerciseSetPerformed =
                new ModelMapper()
                        .map(exerciseSetPerformedDto, ExerciseSetPerformed.class);
        ExerciseSet exerciseSet = exerciseSetRepo.findByNumber(exerciseSetPerformed.getExerciseSet().getNumber());

        exerciseSetPerformed.setExerciseSet(exerciseSet);
        exerciseSetPerformed.getExercisesPerformed().forEach(this::assignExercise);

        ExerciseSetPerformed savedExerciseSetPerformed =
                exerciseSetPerformedRepo.save(exerciseSetPerformed);

        return mapper.map(savedExerciseSetPerformed, ExerciseSetPerformedDto.class);
    }

    private void assignExercise(ExercisePerformed exercisePerformed) {
        String name = exercisePerformed.getExercise().getName();
        Exercise byName = exerciseRepo.findByName(name);
        exercisePerformed.setExercise(byName);
    }


}
