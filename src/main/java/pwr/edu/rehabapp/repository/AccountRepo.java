package pwr.edu.rehabapp.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.Account;

@Repository
public interface AccountRepo extends JpaRepository<Account, String> {

    Account findByEmail(String email);


}
