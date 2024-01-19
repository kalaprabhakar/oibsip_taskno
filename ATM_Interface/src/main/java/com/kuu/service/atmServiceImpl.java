package com.kuu.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuu.dao.IatmDAO;
import com.kuu.model.Account;

@Service("atmservice")
public class atmServiceImpl implements IatmService {
	
	@Autowired
	IatmDAO dao ;

	@Override
	public boolean login(int accno, int pin) throws Exception {
		
		return  dao.login(accno, pin);
	}
	
	@Override
	public void withdraw(float amount, int accno) throws Exception {
		dao.withdraw(amount, accno);
		
	}
@Override
	public void deposite(float amount , int accno) throws Exception {
		dao.deposite(amount , accno);
	   
		
	}
@Override
public void transfer(int accno, int recaccno, float amount) throws Exception {
	dao.transfer(accno, recaccno, amount);
	
}

@Override
public Account miniStatement(int accno) throws Exception {
	dao.miniStatement(accno);
	return dao.miniStatement(accno);
}

}
