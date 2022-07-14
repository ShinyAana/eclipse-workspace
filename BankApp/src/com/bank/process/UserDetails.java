package com.bank.process;

public class UserDetails
{
static long accountNo=121000001L;
long accountNum;
String name;
String mobNO;
int age;
double balance;
public UserDetails(String name,String mobNO,int age)
{
	this.accountNum=accountNo++;
	this.name=name;
	this.mobNO=mobNO;
	this.age=age;
	this.balance=0.0;
}
public UserDetails()
{
	
}
public double getBalance() {
	return balance;
}
public void setBalance(double balance)
{
	this.balance = balance;
}
public void withdraw(double amount)
{
	this.balance=this.balance-amount;
}
public double deposit(double amount)
{
	this.balance=this.balance+amount;
	return this.balance;
}

}
