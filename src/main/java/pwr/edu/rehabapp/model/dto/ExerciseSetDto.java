package pwr.edu.rehabapp.model.dto;


import lombok.*;
import pwr.edu.rehabapp.model.enums.exerciseset.Difficulty;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseSetDto implements Serializable{

    private long number;
    private String name;
    private Difficulty difficulty;
    private int numberOfExercises;


}
