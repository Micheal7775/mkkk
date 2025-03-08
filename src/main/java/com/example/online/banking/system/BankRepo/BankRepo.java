package com.example.online.banking.system.BankRepo;

import com.example.online.banking.system.Model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BankRepo extends JpaRepository<Account,Long> {
  boolean existsByAccountNumber(long accountNumber);
    boolean existsByAccountNumber(Long accountNumber);
    Account findByAccountNumber(long accountNumber);//
}
