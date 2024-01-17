package com.kuu.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kuu.dao.IReservationDAO;
import com.kuu.model.TrainInfo;
import com.kuu.model.User;

@Service("service")
public class ReservationServiceImpl implements IReservationService {

	@Autowired
	private IReservationDAO resdao;

	@Override
	public boolean checkLoginDetails(User user) throws Exception {

		List<String> list = new ArrayList<>();

		list = resdao.userLogin(user);

		if (user.getUserName().equals(list.get(0)) && user.getPassword().equals(list.get(1))) {
			return true;
		}

		return false;
	}

	@Override
	public String fetchTrain(int trainNo) throws Exception {
		return resdao.getTrain(trainNo);

	}

	@Override
	public void insertTicket(TrainInfo info) throws Exception {
		
		 TrainInfo train =resdao.insetData(info);
		 
		 System.out.println("*****Booking Inforamtion*****");
		 System.out.println("=================================");
		 
		 System.out.println(train.toString());
	}
	
	@Override
	public void deletTicket(int pnr) throws Exception {
		
		resdao.deleteTicket(pnr);
		
	}

}