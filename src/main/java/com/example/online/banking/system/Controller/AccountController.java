package com.example.online.banking.system.Controller;

import com.example.online.banking.system.Exception.AccountIdNotFound;
import com.example.online.banking.system.Model.Account;
import com.example.online.banking.system.Service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("account")
public class AccountController {
    @Autowired
    private AccountService accountSerivce;


    @PostMapping("/create")
    public Account create (@RequestBody  Account account) throws AccountIdNotFound {
        return accountSerivce.createAccount(account);
    }
   @GetMapping("/{id}")
    public Account getAccountById(@PathVariable("id") Long id) throws AccountIdNotFound {
        return accountSerivce.getAccountById(id);
   }

@GetMapping()
public List<Account>getAllAccount() throws AccountIdNotFound {
        return accountSerivce.getAllAccount();
}
@PutMapping("/update/{id}")
public Account updateAccount(@PathVariable("id")Long id,@RequestBody Account account) throws AccountIdNotFound {
    return accountSerivce.updateAccount(id,account);
}
   @PutMapping("deposit/{accountNumber}")
    public Account deposit(@PathVariable("accountNumber")Long accountNumber, @RequestBody Map<String, Double> request) throws AccountIdNotFound {
        Double amount=request.get("amount");
        return accountSerivce.deposit(accountNumber,amount);
   }

    @PutMapping("withdraw/{accountNumber}")
    public Account withdraw(@PathVariable("accountNumber")long accountNumber, @RequestBody Map<String,Double> request) throws AccountIdNotFound {
        Double amount=request.get("amount");
        return accountSerivce.withdraw(accountNumber,amount);
    }
    @DeleteMapping("/{id}")
    public String deleteAccount(Long id){
        return accountSerivce.deleteAccount(id);
    }
}
