package pwr.edu.rehabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.edu.rehabapp.entity.ExerciseSet;
import pwr.edu.rehabapp.entity.enums.exerciseset.Difficulty;

public interface ExerciseSetRepo extends JpaRepository<ExerciseSet,Long> {

    ExerciseSet findByNumber(long number);
    boolean existsByNumber(long number);
    ExerciseSet findByDifficulty(Difficulty difficulty);
}
