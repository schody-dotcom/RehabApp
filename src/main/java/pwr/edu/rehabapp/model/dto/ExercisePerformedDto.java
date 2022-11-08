package pwr.edu.rehabapp.model.dto;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//PU: przesyłanie feedbacku - informacje o wykonanym pojedynczym ćwiczeniu
public class ExercisePerformedDto {

    private ExerciseDto exercise;
    private boolean painful;
    private boolean performed;

}
