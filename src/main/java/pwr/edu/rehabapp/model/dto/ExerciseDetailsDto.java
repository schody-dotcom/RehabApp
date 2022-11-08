package pwr.edu.rehabapp.model.dto;

import lombok.*;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//PU: Wykonywanie zestawu ćwiczeń
public class ExerciseDetailsDto extends ExerciseDto {


    private String description; //opis ćwiczenia
    private List<String> target; //obszar/grupa mięśni, na którą dane ćwiczenie oddziałuje
    private List<String> type; //typ ćwiczenia, np. rozciągające, siłowe, masaż

    @Builder
    public ExerciseDetailsDto(String name, int reps, String image, String description, List<String> target, List<String> type) {
        super(name, reps, image); //nazwa ćwiczenia, liczba powtórzeń, obrazek instruktażowy
        this.description = description;
        this.target = target;
        this.type = type;
    }

}
