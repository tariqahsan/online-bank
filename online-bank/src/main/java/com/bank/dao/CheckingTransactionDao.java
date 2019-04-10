package com.bank.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.bank.domain.CheckingTransaction;

public interface CheckingTransactionDao extends CrudRepository<CheckingTransaction, Long> {

    List<CheckingTransaction> findAll();
}
