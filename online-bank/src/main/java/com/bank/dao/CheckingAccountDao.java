package com.bank.dao;

import org.springframework.data.repository.CrudRepository;

import com.bank.domain.CheckingAccount;

/**
 * Created by z00382545 on 10/21/16.
 */
public interface CheckingAccountDao extends CrudRepository<CheckingAccount,Long> {

    CheckingAccount findByAccountNumber (int accountNumber);
}
