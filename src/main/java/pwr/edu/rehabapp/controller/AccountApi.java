package pwr.edu.rehabapp.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pwr.edu.rehabapp.model.dto.AccountDto;
import pwr.edu.rehabapp.service.AccountService;

@AllArgsConstructor
@RestController
@RequestMapping
//Funkcje pomocnicze
public class AccountApi {


    private AccountService accountService;

    @PostMapping("/api/register")
    public ResponseEntity<?> registerAccount(@RequestBody AccountDto accountDto) {
        return ResponseEntity.created(null).body(accountService.saveAccount(accountDto));
    }


}
