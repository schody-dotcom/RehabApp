package pwr.edu.rehabapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pwr.edu.rehabapp.model.dto.ExerciseDetailsDto;
import pwr.edu.rehabapp.model.dto.ExerciseDto;
import pwr.edu.rehabapp.service.ExerciseService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class ExerciseApi {

    private ExerciseService exercises;

    @GetMapping("api/exercise/all")
    public List<ExerciseDetailsDto> getAllExercises() {
        List<ExerciseDetailsDto> result = exercises.findAll();
        return result;
    }

    @PostMapping("api/exercise")
    public ExerciseDetailsDto addExercise(@RequestBody ExerciseDetailsDto exerciseDetailsDto) {
        return exercises.save(exerciseDetailsDto);
    }



    @GetMapping("api/exercise/exercise-set")
    public List<ExerciseDto> getExercisesByExerciseSetNumber(@RequestParam long exerciseSetNumber) {
        return exercises.findExercisesByExerciseSetNumber(exerciseSetNumber);
    }

    @GetMapping("api/exercise/name")
    public ExerciseDetailsDto getExerciseByName(@RequestParam String exerciseName) {
        return exercises.findByName(exerciseName);
    }


}
