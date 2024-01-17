package com.kuu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kuu.model.TrainInfo;
import com.kuu.model.User;

@Repository("dao")
public class ReservationDAOImpl implements IReservationDAO {

	private static final String SELECT_SQL_QUERY = "SELECT * FROM USER WHERE USERNAME = ?";
	private static final String SELECT_SQL_QUERY1 = "SELECT TRAINNAME FROM TRAIN WHERE TRAINNO = ? ";
	private static final String INSERT_SQL_QUERY = "INSERT INTO TICKET VALUES (?,?,?,?,?,?,?)";
	private static final String DELETE_SQL_QUERY = 	"DELETE FROM TICKET WHERE PNR = ?";

	@Autowired
	private DataSource ds;

	@Override
	public List<String> userLogin(User user) throws Exception {

		List<String> login = new ArrayList<>();

		Connection con = ds.getConnection();

		PreparedStatement ps = con.prepareStatement(SELECT_SQL_QUERY);

		ps.setString(1, user.getUserName());

		ResultSet rs = ps.executeQuery();

		rs.next();

		String userName = rs.getString(1);
		String password = rs.getString(2);

		login.add(userName);
		login.add(password);

		return login;

	}

	@Override
	public String getTrain(int trainNo) throws Exception {

		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(SELECT_SQL_QUERY1);
		ps.setInt(1, trainNo);

		ResultSet rs = ps.executeQuery();

		rs.next();

		String trainName = rs.getString(1);
		System.out.println("Train Name is : " + trainName);

		return trainName;

	}

	@Override
	public TrainInfo insetData(TrainInfo info) throws Exception {
		
		Connection conn = ds.getConnection();
		PreparedStatement ps = conn.prepareStatement(INSERT_SQL_QUERY);
		
		Random rd = new Random();
		int pnr  = rd.nextInt(1000000);
		
		info.setPnr(pnr);
		
		ps.setInt(1, info.getTrainNo());
		ps.setString(2, info.getTraiNname());
		ps.setInt(3, pnr);
		ps.setString(4, info.getType());
		ps.setString(5, info.getDate());
		ps.setString(6, info.getFrom());
		ps.setString(7, info.getTo());
		
		int rowSet = ps.executeUpdate();
		
		if(rowSet==1) {
			System.out.println("*******Ticket Booked Successfully*******");
		}else {
			System.out.println("*******Ticket Booking Failure*******");
		}
		
		
		
		return  info ;
		
		
	}
	
	@Override
	public void deleteTicket(int pnr) throws Exception {
		
		Connection con = ds.getConnection();
		PreparedStatement ps = con.prepareStatement(DELETE_SQL_QUERY);
		ps.setInt(1, pnr);
		
		int rowSet = ps.executeUpdate();
		
		if(rowSet==1) {
			System.out.println("Cancelation Done Successfully With PNR Number " + pnr );
			
		}else {
			System.out.println("Cancelation Failure Try After Some Time");
		}
		
	}

}