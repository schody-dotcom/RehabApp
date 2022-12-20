package pwr.edu.rehabapp.entity;


import lombok.*;
import pwr.edu.rehabapp.entity.enums.exerciseset.Type;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private Type type;


    @ManyToMany(mappedBy = "features")
    private List<Exercise> exercises;

}
