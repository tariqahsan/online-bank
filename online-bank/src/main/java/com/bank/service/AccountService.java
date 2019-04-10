package com.bank.service;

import java.security.Principal;

import com.bank.domain.CheckingAccount;
import com.bank.domain.CheckingTransaction;
import com.bank.domain.SavingsAccount;
import com.bank.domain.SavingsTransaction;

public interface AccountService {
	CheckingAccount createCheckingAccount();
    SavingsAccount createSavingsAccount();
    void deposit(String accountType, double amount, Principal principal);
    void withdraw(String accountType, double amount, Principal principal);
    
    
}
