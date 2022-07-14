package com.bank.process;

import java.util.HashMap;
import java.util.Scanner;

public class LogInPage
{
protected static HashMap<Long,UserDetails> repository=new HashMap<>();
String name;
String mobNO;
int age;
long accNo;



	public void accountCreation()
	{
	Scanner input=new Scanner(System.in);
	System.out.println("Enter your name");
	name=input.nextLine();
	System.out.println("Enter your mobile number");
	mobNO=input.nextLine();
	System.out.println("Enter your age");
	age=input.nextInt();
	UserDetails obj=new UserDetails(name,mobNO,age);
	accNo=obj.accountNum;
	System.out.println("This is your account number " + accNo);
	repository.put(accNo,obj);
	System.out.println(repository.get(accNo).name);
	System.out.println("Account created successfully");
//	ApplicationStart obj1=new ApplicationStart();
//	obj1.startProcess();

	
	}

	public void loginAccount()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Enter your Account Number");
		accNo=input.nextLong();
		System.out.println();
		System.out.println("Enter your mobile number");
		input.nextLine();
		mobNO=input.nextLine();
		String checkNum;
		if(repository.get(accNo) != null) {
			checkNum=repository.get(accNo).mobNO;
			if(mobNO.equals(checkNum))
			{
				System.out.println("Correct user");
				LogInPage choice=new LogInPage();
				choice.bankProcess(accNo);
				System.out.println("your account No. "+ repository.get(accNo).accountNum);
			}
			else
			{
				System.out.println("Incorrect username or password...Try again");
				}
			
		}
		else {
			System.out.println("Empty");
		}
		
	}

	private void bankProcess(long accNo)
	{
	Scanner input=new Scanner(System.in);
	boolean isExit = true;
	while(isExit) {
	System.out.println("Enter your process  \n1.Deposit \n2.Withdraw  \n3.Check Balance \n4.Transfer Amount  \n5.Back To Login");
	int ch=input.nextInt();
	switch(ch)
	{
	case 1:
		new Transaction().deposit(accNo);
		break;
		
	case 2:
		new Transaction().withdraw(accNo);
		break;
		
	case 3:
		new Transaction().checkBalance(accNo);
		break;
	
	case 4:
		new Transaction().transferAmt(accNo);
		break;
	case 5:
		isExit = false;
		break;
	
	}
	}
	}

}
