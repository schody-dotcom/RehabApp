package pwr.edu.rehabapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.model.entity.Exercise;
import pwr.edu.rehabapp.model.entity.ExerciseSet;
import pwr.edu.rehabapp.model.enums.exerciseset.Target;
import pwr.edu.rehabapp.model.enums.exerciseset.Type;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
    Exercise findByName(String name);
    Exercise findByTarget(Target target);
    Exercise findByType(Type type);
}
