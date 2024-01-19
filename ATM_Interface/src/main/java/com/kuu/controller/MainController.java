package com.kuu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kuu.model.Account;
import com.kuu.service.IatmService;

@Controller("atmcontroller")
public class MainController {
	
	@Autowired
	IatmService service ;
	
	public boolean login(int accno , int pin)throws Exception{
		
		
		return service.login(accno, pin);
	}
	
	public void withdraw(float amount , int accno) throws Exception {
		service.withdraw(amount, accno);
	}
	
	public void diposite(float amount , int accno) throws Exception {
		service.deposite(amount ,accno);
	}
	
	public void transfer(int accno, int recaccno, float amount) throws Exception{
		service.transfer(accno, recaccno, amount);
	}
	
	public Account miniStatement(int accno) throws Exception{
		
	return	service.miniStatement(accno);
		
	}

}
