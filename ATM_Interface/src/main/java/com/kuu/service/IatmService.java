package com.kuu.service;

import com.kuu.model.Account;

public interface IatmService {
	
	public boolean login(int accno , int pin ) throws Exception ;
	
	public void withdraw(float amount , int accno) throws Exception ;
	
	public void deposite(float amount , int accno) throws Exception ;
	
	public void transfer(int accno, int recaccno, float amount) throws Exception ;
	
	public Account miniStatement(int accno) throws Exception;

}
