package com.cg.creditcardbillpaymen.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpaymen.dao.AccountRepository;
import com.cg.creditcardbillpaymen.entities.Account;
import com.cg.creditcardbillpaymen.exceptions.AccountException;

/************************************************************************************
 *          @author          Rishu Raj
 *          Description      AccountServiceImpl is a class which is used to implement  
 *          				 necessary business logics for methods such as addAccount,
 *          				 removeAccount, updateAccount, getAccount, getAllAccounts.       					  
 *         Version             1.0
 *         Created Date      22-MAR-2021
 ************************************************************************************/

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountRepositoryDao;	

	/************************************************************************************
	 * Method: addAccount
     * Description: To add any account in database using predefined method, saveAndFlush.
     *              There is an exception added, if there is any user id present before 
     *              in the database, which user is trying to add, that exception will be 
     *              thrown.
	 * @returns Account                - adds an account in table
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	@Override
	public String addAccount(Account account) {
		// TODO Auto-generated method stub
		Optional<Account> account1 = accountRepositoryDao.findById(account.getAccountNumber());
		if (account1.isEmpty()) {
			 accountRepositoryDao.saveAndFlush(account);
			return "Account added successfully";
		} else
			throw new AccountException("Account ID already exists.");

	}
	
	/************************************************************************************
	 * Method: deleteAccount
     * Description: To delete any particular account using it's accountNumber
     * 				through deleteById method.
	 * @returns Account                - returns required account 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@Override

	public String removeAccount(long id) {
		// TODO Auto-generated method stub
		if (accountRepositoryDao.findById(id).isPresent()) {
			accountRepositoryDao.deleteById(id);
			return "Account deleted successfully";
		} else {
			throw new AccountException("Account ID doesn't exist.");
		}


	}
	
	/************************************************************************************
	 * Method: updateAccount
     * Description: To update any particular account and their details stored in database
     * 				using save method.
	 * @returns Account                - returns required account 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@Override
	public String updateAccount(long id, Account account) {
		// TODO Auto-generated method stub
		if (accountRepositoryDao.findById(id).isPresent()) {
			//Account account1 = accountRepositoryDao.getById(id);
			 accountRepositoryDao.save(account);
			return "Account updated successfully.";
		} else {
			throw new AccountException("Account ID you're trying to update doesn't exist. Create new Account ID.");
		}
	}

	/************************************************************************************
	 * Method: getAccount
     * Description: To fetch any particular account using it's accountNumber,
     * 				using findById.get() method.
     * 				
	 * @returns Account                - returns required account 
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@Override
	public Account getAccount(long id) {
		// TODO Auto-generated method stub
		if (accountRepositoryDao.findById(id).isPresent()) {
			return accountRepositoryDao.findById(id).get();
		} else {
			throw new AccountException("Account ID doesn't exist.");
		}
	}

	/************************************************************************************
	 * Method: getAllAccounts
     * Description: To fetch all accounts and their details stored in database.
	 * @returns List                - returns list of all accounts
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/

	@Override
	public List<Account> getAllAccounts() {
		// TODO Auto-generated method stub
		return accountRepositoryDao.findAll();
	}

}
