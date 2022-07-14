package com.bank.withdraw;

public class ApplicationStart {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account account = new Account();
		AccountHolder accountHolder = new AccountHolder(account);
		Thread t1 = new Thread(accountHolder);
		Thread t2 = new Thread(accountHolder);
		t1.setName("Janu");
		t2.setName("Ravi");
		
		t1.start();
		t2.start();

	}

}
