package com.cg.creditcardbillpaymen.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.creditcardbillpaymen.entities.Account;

/************************************************************************************
 *          @author          Rishu Raj
 *          Description      AccountRepository is an interface which extends JPA repository.
 *          				 This class belongs to DAO layer. It is used to perform CRUD operations
 *          				 with our entities by defining JPA repositories for automatic 
 *          				 and intelligent implementations.                     					  
 *         Version             1.0
 *         Created Date    22-MAR-2021
 ************************************************************************************/


public interface AccountRepository extends JpaRepository<Account, Long> {
	
}
