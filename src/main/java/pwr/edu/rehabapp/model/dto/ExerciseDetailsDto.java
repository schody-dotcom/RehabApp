package pwr.edu.rehabapp.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ExerciseDetailsDto extends ExerciseDto {


    private String description;
    private List<String> target;
    private List<String> type;

    @Builder
    public ExerciseDetailsDto(String name, int reps, String image, String description, List<String> target, List<String> type) {
        super(name, reps, image);
        this.description = description;
        this.target = target;
        this.type = type;
    }

}
