package pwr.edu.rehabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.ExerciseSetPerformed;

@Repository
public interface ExerciseSetPerformedRepo extends JpaRepository<ExerciseSetPerformed, Long> {

}
