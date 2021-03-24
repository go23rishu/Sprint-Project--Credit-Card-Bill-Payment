package com.cg.creditcardbillpaymen.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.creditcardbillpaymen.dao.AccountRepository;
import com.cg.creditcardbillpaymen.entities.Account;

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
	AccountRepository accountRepositoryDao;
	

	/************************************************************************************
	 * Method: addAccount
     * Description: To add any account in database using predefined method, saveAndFlush.
	 * @returns Account                - adds an account in table
     * Created By- Rishu Raj
     * Created Date- 22-MAR-2021                          
	 
	 ************************************************************************************/
	@Override
	public Account addAccount(Account account) {
		// TODO Auto-generated method stub
		accountRepositoryDao.saveAndFlush(account);
		return accountRepositoryDao.getById(account.getAccountNumber());
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

	public void removeAccount(long id) {
		// TODO Auto-generated method stub
		accountRepositoryDao.deleteById(id);
		
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
	public Account updateAccount(long id, Account account) {
		// TODO Auto-generated method stub
		Account account1=accountRepositoryDao.getById(id);
		accountRepositoryDao.save(account);
		return account;
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
		if(accountRepositoryDao.findById(id).isPresent()) {
			return accountRepositoryDao.findById(id).get();
		}
		else {
			return null;
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
