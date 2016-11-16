package com.multirechargehub.service;

import java.security.SecureRandom;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import com.multirechargehub.model.register;
import com.multirechargehub.utils.DBconnect;
import com.mysql.jdbc.Connection;

public class RegisterServiceImpl implements RegisterService {

	public boolean doRegister(register obj){
		Connection c = null;
		c=DBconnect.getConnection();
		CallableStatement stmt = null;
		int rs=3;
		if(c!=null){
			String query = "{CALL doRegister(?,?,?,?,?,?,?,?,?,?,?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setString(1, obj.get_fname());
				stmt.setString(2, obj.get_email());
				stmt.setInt(3, obj.get_uname());
				stmt.setString(4, obj.get_pwd());
				stmt.setString(5, obj.get_question());
				stmt.setString(6, obj.get_answer());
				stmt.setString(7, obj.get_cusid());
				stmt.setString(8, obj.get_tranid());
				stmt.setString(9, obj.get_otp());
				stmt.setInt(10, obj.get_status());
				stmt.setString(11, obj.get_imei());
				rs=stmt.executeUpdate();
				stmt.close();
				c.close();
			}catch (SQLException e) {
				
				return false;
			}
		}
	
		return (rs!=-1)?true:false;
		
	}

	public String generateOTP() {
		 String chars = "abcdefghijklmnopqrstuvwxyz"
                 + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                 + "0123456789";

    final int PW_LENGTH = 6;
    Random rnd = new SecureRandom();
    StringBuilder pass = new StringBuilder();
    for (int i = 0; i < PW_LENGTH; i++){
        pass.append(chars.charAt(rnd.nextInt(chars.length())));}
    return pass.toString();
		
	}

	public String generateTranid() {
		 String chars = "0123456789" ;

    final int PW_LENGTH = 4;
    Random rnd = new SecureRandom();
    StringBuilder pass = new StringBuilder();
    for (int i = 0; i < PW_LENGTH; i++){
        pass.append(chars.charAt(rnd.nextInt(chars.length())));}
    System.out.println(pass);
    return pass.toString();
	}

	public String generateCusid() {
		 String chars = "abcdefghijklmnopqrstuvwxyz"
                 + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                 + "0123456789";

    final int PW_LENGTH = 6;
    Random rnd = new SecureRandom();
    StringBuilder pass = new StringBuilder();
    for (int i = 0; i < PW_LENGTH; i++){
        pass.append(chars.charAt(rnd.nextInt(chars.length())));}
    return pass.toString();
	}

	public boolean doReSentOtp(String cid) {
		String otp=generateOTP();
		Connection c = null;
		c=DBconnect.getConnection();
		CallableStatement stmt = null;
		int rs=3;
		if(c!=null){
			String query = "{CALL doUpdateOtp(?,?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setString(1, cid);
				stmt.setString(2, otp);
				rs=stmt.executeUpdate();
				stmt.close();
				c.close();
			}catch (SQLException e) {
				return false;
			}
		}
		return ((rs==0)?true:false);
	}

	public boolean doCheckOtp(String cid, String notp) {
		Connection c = null;
		c=DBconnect.getConnection();
		CallableStatement stmt = null;
		ResultSet rs;
		int i=4;
		if(c!=null){
			String query = "{CALL doCheckOtp(?,?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setString(1, cid);
				stmt.setString(2, notp);
				rs=stmt.executeQuery();
				while (rs.next()) {i=rs.getInt(1);}
				stmt.close();
				c.close();
				System.out.println(i);
			}catch (SQLException e) {
				return false;
			}
		}
		return ((i==1)?true:false);
	}

	

}
