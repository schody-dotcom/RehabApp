package pwr.edu.rehabapp.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
//PU: Wykonywanie zestawu ćwiczeń
public class ExerciseDetailsDto extends ExerciseDto {


    private String description; //opis ćwiczenia
    private List<String> targets; //obszar/grupa mięśni, na którą dane ćwiczenie oddziałuje
    private List<String> types; //typ ćwiczenia, np. rozciągające, siłowe, masaż

    @Builder
    public ExerciseDetailsDto(String name, int reps, String image, String description, List<String> target, List<String> type) {
        super(name, reps, image); //nazwa ćwiczenia, liczba powtórzeń, obrazek instruktażowy
        this.description = description;
        this.targets = target;
        this.types = type;
    }

}
