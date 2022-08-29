package pwr.edu.rehabapp.model.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExercisePerformed {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Exercise exercise;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_set_performed_id",
            referencedColumnName = "id")
    private ExerciseSetPerformed exerciseSetPerformed;

    private boolean performed;
    private boolean painful;


}
