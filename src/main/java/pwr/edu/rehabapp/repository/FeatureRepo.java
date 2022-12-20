package pwr.edu.rehabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.Feature;

@Repository
public interface FeatureRepo extends JpaRepository<Feature, Long> {
}
