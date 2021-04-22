package com.cg.creditcardbillpaymen.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.creditcardbillpaymen.dao.AccountRepository;
import com.cg.creditcardbillpaymen.entities.Account;
import com.cg.creditcardbillpaymen.exceptions.AccountException;
import com.cg.creditcardbillpaymen.services.AccountService;

import io.swagger.annotations.Api;

/************************************************************************************
 *          @author          Rishu Raj
 *          Description      It is a RestController class. This class handles all the 
 *          				HTTP Request toward "/accounts" "folder".                      					  
 *         Version             1.0
 *         Created Date    22-MAR-2021
 ************************************************************************************/
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/account")
@Api(value = "Swagger2DemoRestController")
public class AccountController {
	@Autowired
	AccountService accountService;
	
	
	/************************************************************************************
	 * Method: getAllAccounts
     * Description: To fetch all accounts and their details stored in database.
	 * @returns List                - returns list of all accounts
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@GetMapping("/viewall")
	public List<Account> getAllAccounts(){
		return accountService.getAllAccounts();
	}
	
	/************************************************************************************
	 * Method: getAccount
     * Description: To fetch any particular account using it's accountNumber
     * 				
	 * @returns Account                - returns required account 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@GetMapping("/get/{accountNumber}")
	public Account getAccount(@PathVariable long accountNumber) {
		return accountService.getAccount(accountNumber);
		
	}
	
	/************************************************************************************
	 * Method: addAccount
     * Description: To add any account in database.
	 * @returns Account                - adds an account in table
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE)
	public String addAccount(@RequestBody Account account) {
		   return accountService.addAccount(account);
	}
	
	/************************************************************************************
	 * Method: deleteAccount
     * Description: To delete any particular account using it's accountNumber
     * 				throws error when accountNumber not found in database
	 * @returns void                - returns nothing 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@DeleteMapping("/del/{accountNumber}")
	public String removeAccount(@PathVariable long accountNumber){
		return accountService.removeAccount(accountNumber);
	}
	
	/************************************************************************************
	 * Method: updateAccount
     * Description: To update any particular account and their details stored in database.
	 * @returns Account                - returns required account 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@PutMapping("/update")
	public String updateAccount(@RequestBody Account account){
		Long accountNumber=account.getAccountNumber();
		return accountService.updateAccount(accountNumber,account);
	}
	

}
