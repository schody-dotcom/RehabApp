package pwr.edu.rehabapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.Exercise;

@Repository
public interface ExerciseRepo extends CrudRepository<Exercise, Long> {
}
