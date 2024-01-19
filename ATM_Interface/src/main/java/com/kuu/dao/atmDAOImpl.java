package com.kuu.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.spi.DirStateFactory.Result;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kuu.model.Account;

@Repository("atmdao")
public class atmDAOImpl implements IatmDAO {

	private static final String SELECT_SQL_QUERY = "SELECT * FROM ACCOUNT WHERE ACCNO = ?";
	private static final String INSERT_SQL_QUERY = "UPDATE ACCOUNT SET BALANCE = ? WHERE ACCNO = ? ";
	private static final String SELECT_SQL_QUERY1 = "SELECT BALANCE FROM ACCOUNT WHERE ACCNO = ?";

	@Autowired
	DataSource dataSource;

	Account account;

	@Override
	public boolean login(int accno, int pin) throws Exception {

		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(SELECT_SQL_QUERY);
		ps.setInt(1, accno);

		ResultSet rs = ps.executeQuery();

		rs.next();

		int acc_no = rs.getInt(1);
		int pin_no = rs.getInt(2);
		String name = rs.getString(3);
		float bal = rs.getFloat(4);
		String acctype = rs.getString(5);

		account = new Account();
		account.setAcc_no(acc_no);
		account.setName(name);
		account.setAcctype(acctype);
		account.setBal(bal);
		account.setPin(pin_no);

		if (pin == pin_no) {

			System.out.println("Welcome Mr/Mrs :-:" + name);
			return true;
		} else {
			System.out.println("**********Invalid Account Number  & Password*********");
			return false;
		}

	}

	@Override
	public void withdraw(float amount, int accno) throws Exception {

		float bal = account.getBal();

		if (bal < amount) {
			throw new SQLException("Insufficiant Balance");
		} else {

			float lastbal = bal - amount;
			Connection con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(INSERT_SQL_QUERY);
			ps.setFloat(1, lastbal);
			ps.setInt(2, accno);

			int rowCount = ps.executeUpdate();
			if (rowCount == 1) {
				System.out.println("WithDraw Successfull");
				System.out.println("Availabe Balance :" + lastbal);

				account.setBal(lastbal);
			}
		}

	}

	@Override
	public void deposite(float amount, int accno) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(INSERT_SQL_QUERY);

		float bal = account.getBal() + amount;

		ps.setFloat(1, bal);
		ps.setInt(2, accno);

		int rowCount = ps.executeUpdate();
		if (rowCount == 1) {
			System.out.println("Deposit Successfull");
			System.out.println("Availabe balance : " + bal);
			account.setBal(bal);
		} else {
			throw new SQLException("Transaction Failure");
		}

	}

	@Override
	public void transfer(int accno, int recaccno, float amount) throws Exception {

		int rowCount2 = 0;
		int rowCount1 = 0;
		Connection conn = dataSource.getConnection();
		conn.setAutoCommit(false);

		float bal = account.getBal();

		if (bal > amount) {

			PreparedStatement ps = conn.prepareStatement(INSERT_SQL_QUERY);
			ps.setFloat(1, bal - amount);
			ps.setInt(2, accno);

			rowCount1 = ps.executeUpdate();
		} else {
			throw new SQLException("Insufficient Balance");
		}

		PreparedStatement ps1 = conn.prepareStatement(SELECT_SQL_QUERY1);
		ps1.setInt(1, recaccno);

		ResultSet rs = ps1.executeQuery();

		rs.next();

		float recbal = rs.getFloat(1);

		PreparedStatement ps2 = conn.prepareStatement(INSERT_SQL_QUERY);

		ps2.setFloat(1, recbal + amount);
		ps2.setInt(2, recaccno);

		rowCount2 = ps2.executeUpdate();

		if (rowCount1 == 0 || rowCount2 == 0) {
			conn.rollback();
			throw new SQLException("Transaction Failure");
		} else {
			conn.commit();
			System.out.println("Transaction Successfull");
			account.setBal(bal - amount);
			System.out.println("Available Balance : " + account.getBal());
		}

	}
	@Override
	public Account miniStatement(int accno) throws Exception {
		Connection con = dataSource.getConnection();
		PreparedStatement ps = con.prepareStatement(SELECT_SQL_QUERY);
		ps.setInt(1, accno);
		ResultSet rs = ps.executeQuery();
		
		rs.next();

		int acc_no = rs.getInt(1);
		int pin_no = rs.getInt(2);
		String name = rs.getString(3);
		float bal = rs.getFloat(4);
		String acctype = rs.getString(5);
          
		Account account1 = new Account();
		account1 = new Account();
		account1.setAcc_no(acc_no);
		account1.setName(name);
		account1.setAcctype(acctype);
		account1.setBal(bal);
		account1.setPin(pin_no);
		
		return account1;
	}

}
