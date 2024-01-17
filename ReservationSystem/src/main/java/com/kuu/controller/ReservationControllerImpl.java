package com.kuu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.kuu.model.TrainInfo;
import com.kuu.model.User;
import com.kuu.service.IReservationService;

@Controller("controller")
public class ReservationControllerImpl implements IReservationController {

	 @Autowired
	private IReservationService service ;
	
	@Override
	public boolean login(User user) throws Exception {
		
		return service.checkLoginDetails(user);
	}
	
	@Override
	public String retriveTain(int trainNo) throws Exception {
		
		return service.fetchTrain(trainNo);
		
	}
	
	@Override
	public void insertinfo(TrainInfo info) throws Exception {
		
		service.insertTicket(info);
	}
	
	@Override
	public void removeTicket(int pnr) throws Exception {
		service.deletTicket(pnr);
		
	}

}