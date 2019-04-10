package com.bank.service;

import java.security.Principal;
import java.util.List;

import com.bank.domain.CheckingAccount;
import com.bank.domain.CheckingTransaction;
import com.bank.domain.Recipient;
import com.bank.domain.SavingsAccount;
import com.bank.domain.SavingsTransaction;

public interface TransactionService {
	List<CheckingTransaction> findCheckingTransactionList(String username);

    List<SavingsTransaction> findSavingsTransactionList(String username);

    void saveCheckingDepositTransaction(CheckingTransaction checkingTransaction);

    void saveSavingsDepositTransaction(SavingsTransaction savingsTransaction);
    
    void saveCheckingWithdrawTransaction(CheckingTransaction checkingTransaction);
    void saveSavingsWithdrawTransaction(SavingsTransaction savingsTransaction);
    
    void betweenAccountsTransfer(String transferFrom, String transferTo, String amount, CheckingAccount checkingAccount, SavingsAccount savingsAccount) throws Exception;
    
    List<Recipient> findRecipientList(Principal principal);

    Recipient saveRecipient(Recipient recipient);

    Recipient findRecipientByName(String recipientName);

    void deleteRecipientByName(String recipientName);
    
    void toSomeoneElseTransfer(Recipient recipient, String accountType, String amount, CheckingAccount checkingAccount, SavingsAccount savingsAccount);
}
