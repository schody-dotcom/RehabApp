package pwr.edu.rehabapp.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExercisePerformedDto {

    private ExerciseDto exercise;
    private boolean painful;
    private boolean performed;

}
