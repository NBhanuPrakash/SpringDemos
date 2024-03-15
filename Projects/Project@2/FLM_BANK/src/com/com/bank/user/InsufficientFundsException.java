package com.bank.user;

public class InsufficientFundsException extends Exception{
	
	
	public InsufficientFundsException(String msg){
		super(msg);
	}
	
}
