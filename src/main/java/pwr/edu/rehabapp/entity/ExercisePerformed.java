package pwr.edu.rehabapp.entity;


import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//Wykonane ćwiczenie
public class ExercisePerformed {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Jedno ćwiczenie może być wykonane wiele razy
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "exercise_id", referencedColumnName = "id")
    private Exercise exercise;

    //W jednym wykonanym zestawie ćwiczeń znajduje się wiele wykonanych ćwiczeń.
    // Jedno wykonane ćwiczenie należy tylko do jednego wykonanego zestawu
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "exercise_set_performed_id",
            referencedColumnName = "id")
    private ExerciseSetPerformed exerciseSetPerformed;

    private boolean performed;
    private boolean painful;


}
