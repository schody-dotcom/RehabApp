package pwr.edu.rehabapp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pwr.edu.rehabapp.entity.Account;


@Repository
public interface AccountRepo extends CrudRepository<Account, Long> {
}
