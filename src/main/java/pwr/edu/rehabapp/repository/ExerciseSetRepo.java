package pwr.edu.rehabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.edu.rehabapp.model.entity.ExerciseSet;
import pwr.edu.rehabapp.model.enums.exerciseset.Difficulty;

public interface ExerciseSetRepo extends JpaRepository<ExerciseSet,Long> {

    ExerciseSet findByNumber(long number);
    ExerciseSet findByDifficulty(Difficulty difficulty);
}
