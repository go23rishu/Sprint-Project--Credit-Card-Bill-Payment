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
	
	Account account = new Account(1001L, "Rishu", 22200D, "Savings");
	Account account2 = new Account(1002L, "Rohit", 4521D, "savings");
	Account account3 = new Account(1004L, "Kalyan", 5500D, "current");
	
	
	@Test
	void addTest()
	{
		assertEquals("Rishu", accountService.getAccount(account.getAccountNumber()).getAccountName());
	}
	@Test
	void addTest1()
	{
		assertEquals("savings", accountService.getAccount(account2.getAccountNumber()).getType());
	}
	@Test
	void addTest2()
	{
		assertEquals(5500D, accountService.getAccount(account3.getAccountNumber()).getBalance());
	}
	
	@Test
	void getTest()
	{
		assertEquals(22200D, accountService.getAccount(1001L).getBalance());
	}
	@Test
	void getTest1()
	{
		assertEquals("savings", accountService.getAccount(1002L).getType());
	}
	@Test
	void getTest2()
	{
		assertEquals(5500D, accountService.getAccount(1004L).getBalance());
	}
	@Test
	void updateTest()
	{
		assertEquals("Rishu", accountService.getAccount(1001L).getAccountName());
	}
	@Test
	void updateTest2()
	{
		assertEquals(4521D, accountService.getAccount(1002L).getBalance());
	}
	@Test
	void updateTest3()
	{
		assertEquals("current", accountService.getAccount(1004L).getType());
	}
	

}
