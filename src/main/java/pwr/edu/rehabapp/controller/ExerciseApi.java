package pwr.edu.rehabapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.edu.rehabapp.model.dto.ExerciseDetailsDto;
import pwr.edu.rehabapp.model.dto.ExerciseDto;
import pwr.edu.rehabapp.service.ExerciseService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
public class ExerciseApi {

    private ExerciseService exerciseService;

    @GetMapping("api/doctor/exercise/all")
    public List<ExerciseDetailsDto> getAllExercises() {
        List<ExerciseDetailsDto> result = exerciseService.findAll();
        return result;
    }

    @PostMapping("api/doctor/exercise")
    public ExerciseDetailsDto addExercise(@RequestBody ExerciseDetailsDto exerciseDetailsDto) {
        return exerciseService.save(exerciseDetailsDto);
    }


    @GetMapping("api/exercise/exercise-set")
    public ResponseEntity<?> getExercisesByExerciseSetNumber(@RequestParam long exerciseSetNumber) {
        List<ExerciseDto> exercisesByExerciseSetNumber = exerciseService.findExercisesByExerciseSetNumber(exerciseSetNumber);

        if (exercisesByExerciseSetNumber == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(("Exercise Set number " + exerciseSetNumber + " not found"));
        }
        return ResponseEntity.ok(exercisesByExerciseSetNumber);
    }

    // obsluga wyjatkow - wyslac komunikat - nowy obiekt na komunikat trzeba zrobic
    @GetMapping("api/exercise/name")
    public ExerciseDetailsDto getExerciseByName(@RequestParam String exerciseName) {
        return exerciseService.findByName(exerciseName);
    }



}
