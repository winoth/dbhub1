package com.multirechargehub.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.multirechargehub.utils.DBconnect;
import com.multirechargehub.utils.util;
import com.mysql.jdbc.Connection;

public class LoginServiceImpl implements LoginService {

	public boolean checkCredentials(String uname, String pwd) {
		Connection c;
		if(util.isNotNull(uname)&&util.isNotNull(pwd) ){
			c=DBconnect.getConnection();
			if(c!=null){
				String query = "{CALL doLogin(?,?,?)}";
				try {
					CallableStatement stmt = c.prepareCall(query);
					stmt.setInt(1, Integer.parseInt(uname));
					stmt.setString(2, pwd);
					stmt.registerOutParameter(3, java.sql.Types.BIGINT);
					stmt.executeUpdate();
					return ((stmt.getInt(3)>0)?true:false);
				
				} catch (SQLException e) {
				return false;
				}
			}
		}
		return false;
	}

	public boolean pwdReset(String cusid, String newpw) {
		Connection c;
		c=DBconnect.getConnection();
		CallableStatement stmt;
		int rs=3;
		if(c!=null){
			String query = "{CALL doPwdReset(?,?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setString(1, cusid);
				stmt.setString(2, newpw);
				rs=stmt.executeUpdate();
				stmt.close();
				c.close();
				
			}catch (SQLException e) {
				
				return false;
			}
		}
		
		return ((rs==0)?true:false);
	}

	public String getMailid(String cusid) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getPwdResetAnswer(String cusid) {
		Connection c;
		c=DBconnect.getConnection();
		CallableStatement stmt;
		ResultSet rs;
		
		if(c!=null){
			String query = "{CALL getPwdResetAnswer(?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setString(1, cusid);
				rs=stmt.executeQuery();
				while(rs.next()){
					return rs.getString(1);
				}
				
			}catch (SQLException e) {
				return null;

			}
		}
		return null;
	}

	public String getCustomerId(int mno) {
		Connection c;
		c=DBconnect.getConnection();
		CallableStatement stmt;
		ResultSet rs;
		if(c!=null){
			String query = "{CALL getCusId(?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setInt(1, mno);
				rs=stmt.executeQuery();
				while(rs.next()){
					return rs.getString(1);
				}
				
			}catch (SQLException e) {
				return null;

			}
		}
		return null;
	}

}
