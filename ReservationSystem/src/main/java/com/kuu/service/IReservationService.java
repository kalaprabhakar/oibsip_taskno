package com.kuu.service;

import com.kuu.model.TrainInfo;
import com.kuu.model.User;

public interface IReservationService {

	public boolean checkLoginDetails(User user) throws Exception ;
	
	public String fetchTrain(int trainNo) throws Exception ;
	
	public void insertTicket(TrainInfo info) throws Exception ;
	
	public void deletTicket(int pnr) throws Exception ;
}
