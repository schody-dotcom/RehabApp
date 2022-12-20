package pwr.edu.rehabapp.entity;


import lombok.*;
import pwr.edu.rehabapp.entity.enums.exerciseset.Target;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Trait {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Target target;


    @ManyToMany(mappedBy = "traits")
    private List<Exercise> exercises;
}
