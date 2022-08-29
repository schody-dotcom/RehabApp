package pwr.edu.rehabapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.edu.rehabapp.model.dto.ExerciseSetPerformedDto;
import pwr.edu.rehabapp.service.ExerciseSetPerformedService;

@AllArgsConstructor
@RestController
@RequestMapping
public class ExerciseSetPerformedApi {

    private ExerciseSetPerformedService exerciseSetPerformedService;

    @PostMapping("api/feedback/save")
    public ExerciseSetPerformedDto saveFeedback(@RequestBody ExerciseSetPerformedDto dto){
        return exerciseSetPerformedService.save(dto);
    }

}
