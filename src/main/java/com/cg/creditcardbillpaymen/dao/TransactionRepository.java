package com.cg.creditcardbillpaymen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpaymen.entities.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction,String>{

}
