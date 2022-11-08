package pwr.edu.rehabapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.edu.rehabapp.model.dto.ExerciseSetPerformedDto;
import pwr.edu.rehabapp.service.ExerciseSetPerformedService;

@AllArgsConstructor
@RestController
@RequestMapping
//PU: Przesyłanie feedbacku
public class ExerciseSetPerformedApi {

    private ExerciseSetPerformedService exerciseSetPerformedService;

    //PU: Przesyłanie feedbacku
    @PostMapping("api/patient/feedback/save")
    public ResponseEntity<?> saveFeedback(@RequestBody ExerciseSetPerformedDto dto){
        ExerciseSetPerformedDto saveResult = exerciseSetPerformedService.save(dto);
        if (saveResult == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Feedback could not be saved");
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(saveResult);
    }

}
