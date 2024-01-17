package com.kuu.presentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kuu.controller.IReservationController;
import com.kuu.model.TrainInfo;
import com.kuu.model.User;

@Component("presentation")
public class ReservationUI {
	
	@Autowired
	private IReservationController rescontroller ;
	
	public boolean login(User user ) throws Exception {
		
		return rescontroller.login(user);
		
	}
	
	public String booking(int trainNo)throws Exception{
		return rescontroller.retriveTain(trainNo);
	}
	
	public void bookingTicket(TrainInfo info) throws Exception {
		rescontroller.insertinfo(info);
	}
	
	public void cancelTicket( int pnr) throws Exception{
		
		rescontroller.removeTicket(pnr);
		
	}

}
