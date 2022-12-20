package pwr.edu.rehabapp.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Jedno ćwiczenie może być zawarte w wielu zestawach ćwiczeń. Jeden zestaw ćwiczeń może zawierać jedno ćwiczenie o danej nazwie
    @OneToMany(mappedBy = "exercise")
    private List<ExercisePerformed> exercisesPerformed;

    //Jedno ćwiczenie może znajdować się w wielu zestawach. Jeden zestaw może zawierać wiele ćwiczeń
    @ManyToMany(mappedBy = "exercises")
    private List<ExerciseSet> exerciseSets;

    private String name;
    private int reps;
    private String image;
    @Lob
    @Column( length = 100000 )
    private String description;


    @ManyToMany
    @JoinTable(
            name = "exercise_feature",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "feature_id")
    )
    private List<Feature> features;

    @ManyToMany
    @JoinTable(
            name = "exercise_trait",
            joinColumns = @JoinColumn(name = "exercise_id"),
            inverseJoinColumns = @JoinColumn(name = "trait_id")
    )
    private List<Trait> traits;


}
