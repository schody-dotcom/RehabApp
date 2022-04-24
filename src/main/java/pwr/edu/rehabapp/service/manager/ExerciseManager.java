package pwr.edu.rehabapp.service.manager;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.repository.ExerciseRepo;
import pwr.edu.rehabapp.entity.Exercise;

import java.util.Optional;

@Service
public class ExerciseManager {


    private ExerciseRepo exerciseRepo;


    @Autowired
    public ExerciseManager(ExerciseRepo exerciseRepo) {
        this.exerciseRepo = exerciseRepo;
    }

    public Optional<Exercise> findById(Long id){
        return exerciseRepo.findById(id);
    }

    public Iterable<Exercise> findAll(){
        return exerciseRepo.findAll();
    }

    public Exercise save(Exercise exercise){
        return exerciseRepo.save(exercise);
    }

    public void deleteById(Long id){
        exerciseRepo.deleteById(id);
    }




}
