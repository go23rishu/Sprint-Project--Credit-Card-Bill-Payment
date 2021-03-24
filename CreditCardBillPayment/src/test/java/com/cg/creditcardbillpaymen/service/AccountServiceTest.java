package com.cg.creditcardbillpaymen.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.creditcardbillpaymen.entities.Account;
import com.cg.creditcardbillpaymen.services.AccountService;

@SpringBootTest
public class AccountServiceTest {
	
	@Autowired
	private AccountService accountService;
	
	Account account = new Account(10000L, "Rishu Raj", 4500D, "Savings");
	Account account2 = new Account(1002L, "Rohit", 4521D, "savings");
	Account account3 = new Account(1004L, "Kalyan", 5500D, "current");
	
	
	@Test
	void addTest()
	{
		accountService.addAccount(account);
		assertEquals("Rishu Raj", accountService.getAccount(account.getAccountNumber()).getAccountName());
		assertEquals("savings", accountService.getAccount(account2.getAccountNumber()).getType());
		assertEquals(5500D, accountService.getAccount(account3.getAccountNumber()).getBalance());
	}
	
	@Test
	void getTest()
	{
		assertEquals(2500D, accountService.getAccount(1001L).getBalance());
		assertEquals("savings", accountService.getAccount(1002L).getType());
		assertEquals(5500D, accountService.getAccount(1004L).getBalance());
	}
	@Test
	void updateTest()
	{
		accountService.updateAccount(10000L, account);
		assertEquals("Rishu Raj", accountService.getAccount(10000L).getAccountName());
		assertEquals(4521D, accountService.getAccount(1002L).getBalance());
		assertEquals("current", accountService.getAccount(1004L).getType());
	}
	
	

}
