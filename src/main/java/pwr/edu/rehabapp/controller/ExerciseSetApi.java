package pwr.edu.rehabapp.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pwr.edu.rehabapp.model.dto.ExerciseSetDto;
import pwr.edu.rehabapp.model.dto.request.ExerciseToExerciseSetDto;
import pwr.edu.rehabapp.service.ExerciseService;
import pwr.edu.rehabapp.service.ExerciseSetService;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping
public class ExerciseSetApi {

    private ExerciseSetService exerciseSets;
    private ExerciseService exercises;

    @GetMapping("api/doctor/exerciseset/all")
    public List<ExerciseSetDto> getExerciseAll() {
        List<ExerciseSetDto> sets = exerciseSets.findAll();
        return sets;
    }

    @GetMapping("api/exerciseset")
    public List<ExerciseSetDto> getExerciseSetByPatient(@RequestParam long patientNumber) {
        List<ExerciseSetDto> sets = exerciseSets.findExerciseSetByPatientNumber(patientNumber);
        return sets;
    }

    @PostMapping("api/exerciseset")
    public ExerciseSetDto postExerciseSet(@RequestBody ExerciseSetDto dto) {
        return exerciseSets.save(dto);
    }

    @PostMapping("api/doctor/exerciseset/exercise")
    public ExerciseSetDto assignExerciseToExerciseSet(@RequestBody ExerciseToExerciseSetDto dto) {
        return exerciseSets.assignExerciseToExerciseSet(dto);
    }
}
