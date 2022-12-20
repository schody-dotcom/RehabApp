package pwr.edu.rehabapp.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//Informacje, które będą znajdowały się w podglądzie pojedynczego zestawu ćwiczeń
public class ExerciseDto implements Serializable {

    private String name;
    private int reps;
    private String image;


}
