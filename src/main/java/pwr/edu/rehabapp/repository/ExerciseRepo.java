package pwr.edu.rehabapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.Exercise;

@Repository
public interface ExerciseRepo extends JpaRepository<Exercise, Long> {
    Exercise findByName(String name);

}
