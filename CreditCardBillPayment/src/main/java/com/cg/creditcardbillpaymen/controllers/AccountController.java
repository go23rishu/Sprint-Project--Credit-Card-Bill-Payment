package com.cg.creditcardbillpaymen.controllers;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

	@GetMapping
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

	@GetMapping("/{accountNumber}")
	public ResponseEntity<Account> getAccount(@PathVariable long accountNumber) {
		Account account=accountService.getAccount(accountNumber);
		if(account!=null)
			return new ResponseEntity<Account>(account,HttpStatus.OK); 
		else
			throw new AccountException("Movie ID doesn't exist.");
	}
	
	/************************************************************************************
	 * Method: addAccount
     * Description: To add any account in database.
	 * @returns Account                - adds an account in table
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@PostMapping(value="/insertaccount", consumes=MediaType.APPLICATION_JSON_VALUE)
	public Account addAccount(@RequestBody Account account) {
		   return accountService.addAccount(account);
	}
	
	/************************************************************************************
	 * Method: deleteAccount
     * Description: To delete any particular account using it's accountNumber
     * 				throws error when accountNumber not found in database
	 * @returns Account                - returns required account 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@DeleteMapping("/{accountNumber}")
	public void removeAccount(@PathVariable long accountNumber){
		 Account account2=accountService.getAccount(accountNumber);
		 if(account2 != null)
			 accountService.removeAccount(accountNumber);
		 else
			 throw new AccountException("Account ID doesn't exist in Database to delete");
	}
	
	/************************************************************************************
	 * Method: updateAccount
     * Description: To update any particular account and their details stored in database.
	 * @returns Account                - returns required account 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@PutMapping("/updateaccount")
	public Account updateAccount(@RequestBody Account account){
		Long accountNumber=account.getAccountNumber();
		return accountService.updateAccount(accountNumber,account);
	}
	

}
