package pwr.edu.rehabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.edu.rehabapp.entity.ExercisePerformed;

public interface ExercisePerformedRepo extends JpaRepository<ExercisePerformed, Long> {
}
