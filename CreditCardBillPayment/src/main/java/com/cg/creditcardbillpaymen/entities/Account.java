package com.cg.creditcardbillpaymen.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

/************************************************************************************
 *          @author          Rishu Raj
 *          Description      Account is a POJO class that has entity Account which
 *          				 defines the necessary attributes. Also defines 
 *          				 its constructors and setters & getter for each variables. 
 *         @param accountNumber - Customer's Account Number
 *         @param accountName   - Customer's Name
 *         @param balance       - Balance Amount in Account
 *         @param type  		- Type of Account          					  
 *         Version             1.0
 *         Created Date      21-MAR-2021
 ************************************************************************************/


@Entity
public class Account {
	@Id
	private Long accountNumber;
	private String accountName;
	private double balance;
	private String type;

	public Account() {
		super();
	}

	public Account(Long accountNumber, String accountName, double balance, String type) {
		super();
		this.accountNumber = accountNumber;
		this.accountName = accountName;
		this.balance = balance;
		this.type = type;
	}

	public Long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(Long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "Account [accountNumber=" + accountNumber + ", accountName=" + accountName + ", balance=" + balance
				+ ", type=" + type + "]";
	}
}
