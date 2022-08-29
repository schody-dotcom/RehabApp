package pwr.edu.rehabapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.model.entity.Appointment;

@Repository
public interface AppointmentRepo extends JpaRepository<Appointment, Long> {
}
