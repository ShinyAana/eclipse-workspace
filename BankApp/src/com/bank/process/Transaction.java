package com.bank.process;

import java.util.Scanner;

public class Transaction 
{

	public void deposit(long accNo) 
	{
Scanner input=new Scanner(System.in);
System.out.println("Enter amount to deposit ");
double amount=input.nextDouble();
//double balance=LogInPage.repository.get(accNo).getBalance();

double afterDeposit=LogInPage.repository.get(accNo).deposit(amount);
System.out.println("Your balance " + afterDeposit);

	
	}

	public void withdraw(long accNo)
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter amount to withdraw");
		double amount=input.nextDouble();
		double balance=LogInPage.repository.get(accNo).getBalance();
if(balance>=amount)
{
		LogInPage.repository.get(accNo).withdraw(amount);
		double afterWithdraw=LogInPage.repository.get(accNo).getBalance();
		System.out.println("Your balance " + afterWithdraw);

}
else
{
	System.out.println("InSufficient Balance");
}
		
	}

	public void checkBalance(long accNo) 
	{
		double balance;
	//UserDetails user=new UserDetails();
	balance=LogInPage.repository.get(accNo).getBalance();
	System.out.println("Your account balance "+ balance);

	}

	public void transferAmt(long accNo)
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter amount to transfer ");
	double transferAmt=input.nextDouble();
	double balance=LogInPage.repository.get(accNo).getBalance();
	if(balance>=transferAmt)
	{
		System.out.println("Enter the account number you want to transfer money ");
		long transferAcc=input.nextLong();
		if(LogInPage.repository.get(transferAcc)!=null)
		{
			LogInPage.repository.get(accNo).withdraw(transferAmt);
			LogInPage.repository.get(transferAcc).deposit(transferAmt);
			double balanceAfterTransfer=LogInPage.repository.get(accNo).getBalance();
			System.out.println("Your transaction made successfully");
			System.out.println("Balance amount after transfer " + balanceAfterTransfer);
		}
		else
		{
			System.out.println("Invalid transfer account number ");
		}
	}
	else
	{
		System.out.println("Insufficient balance to transfer");
	}
	
	}

}
