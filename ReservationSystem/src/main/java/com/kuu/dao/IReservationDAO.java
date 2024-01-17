package com.kuu.dao;

import java.util.List;

import com.kuu.model.TrainInfo;
import com.kuu.model.User;

public interface IReservationDAO {
	
	public List<String> userLogin(User user) throws Exception;
	
	public String getTrain(int trainNo)throws Exception ;
	
	public TrainInfo insetData(TrainInfo info) throws Exception ;
	
	public void deleteTicket(int pnr) throws Exception;
	

}
