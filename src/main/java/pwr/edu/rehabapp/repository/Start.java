package pwr.edu.rehabapp.repository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import pwr.edu.rehabapp.entity.Account;
import pwr.edu.rehabapp.entity.Contact;
import pwr.edu.rehabapp.entity.User;

import java.util.ArrayList;

@Component
public class Start {


    private UserRepo userRepo;
    private ContactRepo contactRepo;
    private AccountRepo accountRepo;


    @Autowired
    public Start(UserRepo userRepo, ContactRepo contactRepo, AccountRepo accountRepo) {
        this.userRepo = userRepo;
        this.contactRepo = contactRepo;
        this.accountRepo = accountRepo;
    }



    @EventListener(ApplicationReadyEvent.class)
    public void run() {
        ArrayList<Contact> kontakty1 = new ArrayList<>();
        Account account1 = new Account("pacjent1", "haslo");
        User user1 = new User("pacjent", account1, false, kontakty1, "Jan", "Kowalski");
        accountRepo.save(account1);
        userRepo.save(user1);
    }
}
