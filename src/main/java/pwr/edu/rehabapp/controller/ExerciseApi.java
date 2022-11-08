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
//PU: Przeglądanie zestawów ćwiczeń
public class ExerciseApi {

    private ExerciseService exerciseService;


    /* PU: Dodatkowa funkcjonalność do Przeglądanie zastawów ćwiczeń: podgląd pojedynczego zestawu z listy. W podglądzie
     widnieć będzie lista ćwiczeń (List<ExerciseDto>) z podstawowymi inofrmacjami o ćwiczeniu (name, image, reps) */
    @GetMapping("api/exercise/exercise-set")
    public ResponseEntity<?> getExercisesByExerciseSetNumber(@RequestParam long exerciseSetNumber) {
        List<ExerciseDto> exercisesByExerciseSetNumber = exerciseService.findExercisesByExerciseSetNumber(exerciseSetNumber);

        if (exercisesByExerciseSetNumber == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Exercise Set number " + exerciseSetNumber + " not found");
        }
        return ResponseEntity.ok(exercisesByExerciseSetNumber);
    }

    /*---------------------------------------------------------------------------------------------------------------*/
    //Funkcje pomocnicze


    //funkcja pomocnicza - dla roli lekarza
    @GetMapping("api/doctor/exercise/name")
    public ResponseEntity getExerciseByName(@RequestParam String exerciseName) {
        ExerciseDetailsDto exerciseByName = exerciseService.findByName(exerciseName);

        if (exerciseByName == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Exercise " + exerciseName + " not found");
        }
        return ResponseEntity.ok(exerciseByName);
    }

    //pobieranie wszystkich ćwiczeń
    @GetMapping("api/doctor/exercise/all")
    public List<ExerciseDetailsDto> getAllExercises() {
        List<ExerciseDetailsDto> result = exerciseService.findAll();
        return result;
    }

    //dodawanie ćwiczenia
    @PostMapping("api/doctor/exercise")
    public ExerciseDetailsDto addExercise(@RequestBody ExerciseDetailsDto exerciseDetailsDto) {
        return exerciseService.save(exerciseDetailsDto);
    }




}
