package pwr.edu.rehabapp.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ExerciseDto implements Serializable {

    private String name;
    private int reps;
    private String image;


}
