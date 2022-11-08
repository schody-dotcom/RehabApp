package pwr.edu.rehabapp.model.entity;


import lombok.*;
import pwr.edu.rehabapp.model.enums.exerciseset.Target;
import pwr.edu.rehabapp.model.enums.exerciseset.Type;

import javax.persistence.*;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

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
    private String description;


    @ElementCollection(targetClass = Target.class)
    @JoinTable(
            name = "target_exercise",
            joinColumns = @JoinColumn(name = "exercise_id")
    )
    @Column(name = "target", nullable = false)
    private Set<Target> target;

    @ElementCollection(targetClass = Type.class)
    @JoinTable(
            name = "type_exercise",
            joinColumns = @JoinColumn(name = "exercise_id")
    )
    @Column(name = "type", nullable = false)
    private Set<Type> type;


}
