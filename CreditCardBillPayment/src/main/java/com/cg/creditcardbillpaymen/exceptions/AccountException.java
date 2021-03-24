package com.cg.creditcardbillpaymen.exceptions;

/************************************************************************************
 *          @author          Rishu Raj
 *          Description      AccountException is an exception class which is used to
 *          				 throw user defined exception at run time. It extends Runtime
 *          				 Exception class.                    					  
 *         Version             1.0
 *         Created Date      22-MAR-2021
 ************************************************************************************/

public class AccountException extends RuntimeException {

	public AccountException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
