package com.cg.creditcardbillpaymen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpaymen.entities.Address;

public interface AddressRepository extends JpaRepository<Address,String>{

}
