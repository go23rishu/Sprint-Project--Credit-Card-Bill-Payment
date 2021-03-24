package com.cg.creditcardbillpaymen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpaymen.entities.CreditCard;



public interface CreditCardRepository extends JpaRepository<CreditCard,Long>{

}
