package com.cg.creditcardbillpaymen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpaymen.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer,String>{

}
