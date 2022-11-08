package pwr.edu.rehabapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pwr.edu.rehabapp.model.dto.ExerciseSetDto;
import pwr.edu.rehabapp.model.dto.request.ExerciseToExerciseSetDto;
import pwr.edu.rehabapp.service.ExerciseService;
import pwr.edu.rehabapp.service.ExerciseSetService;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping
//PU: Wykonywanie zestawu ćwiczeń / Przeglądanie zestawów ćwiczeń
public class ExerciseSetApi {

    private ExerciseSetService exerciseSetService;
    private ExerciseService exercises;

    /*PU: Wykonywanie zestawu ćwiczeń - pobieranie całego zestawu ze wszystkimi szczegółami
     (ExerciseSetDto zawiera listę ćwiczeń) */
    @GetMapping("api/exerciseset")
    public ResponseEntity<?> getExerciseSetByNumber(@RequestParam long setNumber) {
        ExerciseSetDto dto = exerciseSetService.findByNumber(setNumber);
        if (dto == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Exercise set with number: " + setNumber + " not found");
        }
        return ResponseEntity.ok(dto);
    }

    //PU: Przeglądanie zestawów ćwiczeń
    @GetMapping("api/exerciseset/patient")
    public ResponseEntity<?> getExerciseSetsByPatient(@RequestParam long patientNumber) {
        List<ExerciseSetDto> sets = exerciseSetService.findExerciseSetsByPatientNumber(patientNumber);

        if (sets == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Patient with number: " + patientNumber + " not found");
        }
        return ResponseEntity.ok(sets);
    }

/*--------------------------------------------------------------------------------------------------------------------*/
//Metody pomocnicze


    //Pobranie listy wszystkich zestawów ćwiczeń
    @GetMapping("api/doctor/exerciseset/all")
    public List<ExerciseSetDto> getExerciseAll() {
        List<ExerciseSetDto> sets = exerciseSetService.findAll();
        return sets;
    }

    //Dodawanie zestawu ćwiczeń
    @PostMapping("api/exerciseset")
    public ExerciseSetDto postExerciseSet(@RequestBody ExerciseSetDto dto) {
        return exerciseSetService.save(dto);
    }

    //Przypisywanie zestawu ćwiczeń pacjentowi
    @PostMapping("api/doctor/exerciseset/exercise")
    public ExerciseSetDto assignExerciseToExerciseSet(@RequestBody ExerciseToExerciseSetDto dto) {
        return exerciseSetService.assignExerciseToExerciseSet(dto);
    }
}
