package pwr.edu.rehabapp.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int reps;
    private String image;
    private String description;

    @OneToMany
    private List<ExercisePerformed> exercisesPerformed;

    @ManyToOne
    private ExerciseSet exerciseSet;

    public Exercise(String name, int reps, String image, String description) {
        this.name = name;
        this.reps = reps;
        this.image = image;
        this.description = description;
    }


}
