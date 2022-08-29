package pwr.edu.rehabapp.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pwr.edu.rehabapp.model.entity.ExerciseSet;
import pwr.edu.rehabapp.model.enums.exerciseset.Difficulty;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseSetPerformedDto {

    private long exerciseSetNumber;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;
    private List<ExercisePerformedDto> exercisesPerformed;
    private Difficulty difficulty;
    private int assessment;
    private String message;


}
