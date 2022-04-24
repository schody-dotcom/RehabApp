package pwr.edu.rehabapp.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.Contact;

@Repository
public interface ContactRepo
        extends CrudRepository<Contact, Long> {
}
