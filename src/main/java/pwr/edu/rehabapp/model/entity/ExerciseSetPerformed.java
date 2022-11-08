package pwr.edu.rehabapp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import pwr.edu.rehabapp.model.enums.exerciseset.Difficulty;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExerciseSetPerformed {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Tabela łącząca wykonany zestaw ćwiczeń z pacjentem, który go wykonał
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private Patient patient;

    //Jeden wykonany zestaw ćwiczeń zawiera wiele wykonancyh pojedynczych ćwiczeń. Jedno wykonane ćwiczenie jest
    //przypisane do jednego wykonanego zestawu
    @OneToMany(mappedBy = "exerciseSetPerformed", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<ExercisePerformed> exercisesPerformed;

    //Tabela łącząca wykonany zestaw ćwiczeń z zestawem do wykonania.
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_set_id", referencedColumnName = "id")
    private ExerciseSet exerciseSet;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    private int assessment;
    private String message;

}
