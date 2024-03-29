package pwr.edu.rehabapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.model.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

     User findByNumber(long number);

}
