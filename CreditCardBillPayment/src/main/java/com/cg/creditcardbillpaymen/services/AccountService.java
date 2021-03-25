package com.cg.creditcardbillpaymen.services;

import java.util.List;

import com.cg.creditcardbillpaymen.entities.Account;

/************************************************************************************
 *          @author          Rishu Raj
 *          Description      AccountService is an interface which is used to define 
 *          				 necessary business logics whose implementation is defined
 *          				 in AccountServiceImpl class. Here, necessary methods such as addAccount,
 *          				 removeAccount, updateAccount, getAccount, getAllAccounts are
 *          			     used to perform CRUD operations in service layer.              					  
 *         Version             1.0
 *         Created Date      22-MAR-2021
 ************************************************************************************/


public interface AccountService {
	public String addAccount(Account account);

	public String removeAccount(long id);

	public Account updateAccount(long id, Account account);

	public Account getAccount(long id);

	public List<Account> getAllAccounts();
}
