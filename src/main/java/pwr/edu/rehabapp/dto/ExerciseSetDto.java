package pwr.edu.rehabapp.dto;


import lombok.*;
import pwr.edu.rehabapp.entity.enums.exerciseset.Difficulty;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//PU: Wykonywanie ćwiczeń / Przeglądanie zestawów ćwiczeń
public class ExerciseSetDto implements Serializable{

    private long number;
    private String name;
    private Difficulty difficulty;
    private int numberOfExercises;
    private List<ExerciseDetailsDto> exercises;

}
