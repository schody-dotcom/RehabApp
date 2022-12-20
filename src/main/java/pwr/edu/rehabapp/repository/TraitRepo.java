package pwr.edu.rehabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.Trait;

@Repository
public interface TraitRepo extends JpaRepository<Trait, Long> {

}
