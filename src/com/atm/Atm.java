package com.atm;

import java.util.Random;
import java.util.Scanner;

public class Atm {
	
	private int accountno;
	private int amount;
	private int pin;
	
	public Atm() {
		
		this.accountno = new Random().nextInt(999999);
		this.amount = 1000;
		this.pin = new Random().nextInt(9999);
	    welcome();
	}
	

	public int getAccountno() {
		return accountno;
	}

	public void setAccountno(int accountno) {
		this.accountno = accountno;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	
	public void welcome() {
	    System.out.println("Account No: " + accountno + ", Amount: " + amount + ", Pin: " + pin);
	}

	
	
	public String pinchange(int accountno,int oldpin,int newpin,int confirmpin)
	{
		
		if(accountno != getAccountno())
		{
			return "invalid account number";
		}
		if(oldpin != getPin())
		{
			return "invalid pin";
		}
		
		if((newpin <1000 || newpin >9999)|| (confirmpin <1000 || confirmpin >9999))
		{
			return "pin must be 4 digits only";
		}
		
		if(newpin != confirmpin)
		{
			return "newpin and confirmpin doesn't match";
		}
		
		setPin(confirmpin);
		
		return "pin updated successfully";
		
	}
	
	public static void main(String[] args) {
		
		Atm a = new Atm();
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("enter accountno");
		int accountno =sc.nextInt();
		
		System.out.println("enter oldpin");
		int oldpin =sc.nextInt();
		
		System.out.println("enter newpin");
		int newpin=sc.nextInt();
		
		System.out.println("enter confirmpin");
		int confirmpin= sc.nextInt();
		
		String result =a.pinchange(accountno,oldpin, newpin, confirmpin);
		
		System.out.println(result);
		a.welcome();
		
	}
	
	


}
