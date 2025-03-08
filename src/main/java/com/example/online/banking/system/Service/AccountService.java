package com.example.online.banking.system.Service;

import com.example.online.banking.system.BankRepo.BankRepo;
import com.example.online.banking.system.Exception.AccountIdNotFound;
import com.example.online.banking.system.Model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private BankRepo bankRepo;


    public Account createAccount(Account account) throws AccountIdNotFound {
        if(bankRepo.existsByAccountNumber(account.getAccountNumber())){
            throw new AccountIdNotFound("the account number already exist" +account.getAccountNumber());
        }
        return bankRepo.save(account);
    }

    public Account getAccountById(Long id) throws AccountIdNotFound {
        return bankRepo.findById(id).orElseThrow(() -> new AccountIdNotFound("account Id Not found "));
    }

    public Account deposit(long accountNumber, Double amount) throws AccountIdNotFound {
        Account account = bankRepo.findByAccountNumber(accountNumber);
        if(account==null){
            throw new AccountIdNotFound("account not found"+accountNumber);
        }
        if(amount==null|| amount==0){
            throw new AccountIdNotFound("amount not null or zero  " +amount);

        }
        account.setBalance(account.getBalance() + amount);
        return bankRepo.save(account);
    }

    public Account withdraw(long accountNumber,  Double amount ) throws AccountIdNotFound {
     Account account=bankRepo.findByAccountNumber(accountNumber);
        if(account==null){
            throw new AccountIdNotFound("account not found"+accountNumber);
        }
        if(amount==null ||amount==0){
            throw new AccountIdNotFound("amount not null or zero  " +amount);
        } else if (account.getBalance() < amount) {
            throw new AccountIdNotFound("insufficient balance");
        }
        account.setBalance(account.getBalance() - amount);
        return bankRepo.save(account);
    }


    public List<Account> getAllAccount() throws AccountIdNotFound {
        List<Account>accounts=bankRepo.findAll();
        if (accounts.isEmpty()){
            throw new AccountIdNotFound("the account id empty" +getAllAccount());
        }
        return bankRepo.findAll();
    }

    public Account updateAccount(Long id, Account account) throws AccountIdNotFound {
        Account account1=bankRepo.findById(id).orElseThrow(()->new AccountIdNotFound("accountNotFound "+id));
        account1.setAccountHolderName(account.getAccountHolderName());
        account1.setAccountNumber(account.getAccountNumber());
        account1.setBalance(account.getBalance());
        return bankRepo.save(account1);
    }

    public String deleteAccount(Long id) {
        bankRepo.deleteById(id);
        return "account deleted successfully";
    }
}
