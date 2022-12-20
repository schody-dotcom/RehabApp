package pwr.edu.rehabapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pwr.edu.rehabapp.entity.Patient;

public interface PatientRepo extends JpaRepository<Patient, Long> {
    Patient findByNumber(long number);
}
