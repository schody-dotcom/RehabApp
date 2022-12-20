package pwr.edu.rehabapp.service;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import pwr.edu.rehabapp.dto.AccountDto;
import pwr.edu.rehabapp.entity.Account;
import pwr.edu.rehabapp.repository.AccountRepo;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class AccountService implements UserDetailsService {

    private final AccountRepo accountRepo;
    private final PasswordEncoder passwordEncoder;
    private static final ModelMapper mapper = new ModelMapper();

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account account = accountRepo.findByEmail(email);
        if (account == null) {
            log.error("User not found in the database");
            throw new UsernameNotFoundException("User not found in the database");
        } else {
            log.info("User found in the database: {}", email);
        }

        Collection<SimpleGrantedAuthority> authority = List.of(new SimpleGrantedAuthority(account.getRole().toString()));
        return new org.springframework.security.core.userdetails.User(account.getEmail(), account.getPassword(), authority);
    }

    public AccountDto saveAccount(AccountDto accountDto) {
        Account account = mapper.map(accountDto, Account.class);
        Account savedAccount = accountRepo.save(account);
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        return mapper.map(savedAccount, AccountDto.class);
    }


}
