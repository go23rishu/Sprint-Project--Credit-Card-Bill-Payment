package com.cg.creditcardbillpaymen.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cg.creditcardbillpaymen.entities.Account;
import com.cg.creditcardbillpaymen.services.AccountService;

/************************************************************************************
 *          @author          Rishu Raj
 *          Description      It is a SpringBootTest class. This class handles 
 *          				 all the test cases and defines the junit test cases
 *          				 according to TDD approach.            					  
 *         Version             1.0
 *         Created Date    22-MAR-2021
 ************************************************************************************/




@SpringBootTest
public class AccountServiceTest {

	@Autowired
	private AccountService accountService;

	Account account = new Account(1001L, "Rishu", 22200D, "Savings");
	Account account2 = new Account(1002L, "Rohit", 4521D, "savings");
	Account account3 = new Account(1004L, "Kalyan", 5500D, "current");

	/************************************************************************************
	 * Method: addTest()
     * Description: To test if any account is added to database or not.
	 * @returns void                - JUnit test case to decide the given test case 
	 * 								  is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	
	@Test
	void addTest() {
		assertEquals("Rishu", accountService.getAccount(account.getAccountNumber()).getAccountName());
	}

	/************************************************************************************
	 * Method: addTest1()
     * Description: To test if any account is added to database or not.
	 * @returns void                - JUnit test case to decide the given test case 
	 * 								  is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	
	@Test
	void addTest1() {
		assertEquals("savings", accountService.getAccount(account2.getAccountNumber()).getType());
	}

	/************************************************************************************
	 * Method: addTest2()
     * Description: To test if any account is added to database or not.
	 * @returns void                - JUnit test case to decide the given test case 
	 * 								  is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	
	@Test
	void addTest2() {
		assertEquals(5500D, accountService.getAccount(account3.getAccountNumber()).getBalance());
	}
	/************************************************************************************
	 * Method: getTest()
     * Description: To test if correct detail is fetched from database on giving any input id.
	 * @returns void                - JUnit test case to decide the given test case for fetching 
	 * 								  details using Id is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	
	@Test
	void getTest() {
		assertEquals(22200D, accountService.getAccount(1001L).getBalance());
	}
	
	/************************************************************************************
	 * Method: getTest1()
     * Description: To test if correct detail is fetched from database on giving any input id.
	 * @returns void                - JUnit test case to decide the given test case for fetching 
	 * 								  details using Id is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	@Test
	void getTest1() {
		assertEquals("savings", accountService.getAccount(1002L).getType());
	}
	
	/************************************************************************************
	 * Method: getTest2()
     * Description: To test if correct detail is fetched from database on giving any input id.
	 * @returns void                - JUnit test case to decide the given test case for fetching 
	 * 								  details using Id is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	@Test
	void getTest2() {
		assertEquals(5500D, accountService.getAccount(1004L).getBalance());
	}

	/************************************************************************************
	 * Method: updateTest()
     * Description: 	To test if details are updated into database correctly.
	 * @returns void                - JUnit test case to decide the given test case for updating 
	 * 								  account details using Id is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	
	@Test
	void updateTest() {
		assertEquals("Rishu", accountService.getAccount(1001L).getAccountName());
	}

	/************************************************************************************
	 * Method: updateTest2()
     * Description: 	To test if details are updated into database correctly.
	 * @returns void                - JUnit test case to decide the given test case for updating 
	 * 								  account details using Id is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	
	@Test
	void updateTest2() {
		assertEquals(4521D, accountService.getAccount(1002L).getBalance());
	}
	
	/************************************************************************************
	 * Method: updateTest3()
     * Description: 	To test if details are updated into database correctly.
	 * @returns void                - JUnit test case to decide the given test case for updating 
	 * 								  account details using Id is correct or not.
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@Test
	void updateTest3() {
		assertEquals("current", accountService.getAccount(1004L).getType());
	}

}
