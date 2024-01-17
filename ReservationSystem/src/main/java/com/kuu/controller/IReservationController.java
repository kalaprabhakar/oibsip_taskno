package com.kuu.controller;

import com.kuu.model.TrainInfo;
import com.kuu.model.User;

public interface IReservationController {
	
	public boolean login(User user) throws Exception ;
	
	public String retriveTain(int trainNo) throws Exception ;
	
	public void insertinfo(TrainInfo info) throws Exception ;
	
	public void removeTicket(int pnr) throws Exception ;

}
