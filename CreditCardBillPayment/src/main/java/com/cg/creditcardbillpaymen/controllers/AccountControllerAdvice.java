package com.cg.creditcardbillpaymen.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.cg.creditcardbillpaymen.exceptions.AccountException;
/************************************************************************************
 *          @author          Rishu Raj
 *          Description      AccountControllerAdvice is a RestControllerAdvice class. 
 *          				This class help us to handle Exception with RestfulApi by a 
 *          				cross-cutting concern solution: AccountException. 
 *          				                     					  
 *         Version             1.0
 *         Created Date    22-MAR-2021
 ************************************************************************************/


@RestControllerAdvice
public class AccountControllerAdvice {
	
	/************************************************************************************
	 * Method: creditCardException
     * Description: To handle exceptions at runtime, using @ExceptionHandler.
	 * @returns String                - returns error message
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	
	@ExceptionHandler(AccountException.class)
	public String creditCardException(Exception e)
	{
		return e.getMessage();
	}

}
