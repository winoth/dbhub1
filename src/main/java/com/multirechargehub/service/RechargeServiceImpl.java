package com.multirechargehub.service;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.multirechargehub.model.recharge;
import com.multirechargehub.utils.DBconnect;
import com.mysql.jdbc.Connection;

public class RechargeServiceImpl implements RechargeService {

	public boolean doRecharge(recharge obj) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean insertDB(recharge obj) {
		Connection c = null;
		c=DBconnect.getConnection();
		CallableStatement stmt = null;
		int rs=3;
		if(c!=null){
			String query = "{CALL doRecharge(?,?,?,?,?,?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setInt(1, obj.get_mno());
				stmt.setString(2, obj.get_operetaor());
				stmt.setInt(3, obj.get_amt());
				stmt.setString(4, obj.get_cusid());
				stmt.setString(5, obj.get_trnid());
				stmt.setString(6, obj.get_cuoponcode());
				rs=stmt.executeUpdate();
				stmt.close();
				c.close();
			}catch (Exception e) {
				return false;
			}
		}
		return (rs!=-1)?true:false;
	}

	public ArrayList<recharge> populate(recharge obj) {
		Connection c = null;
		c=DBconnect.getConnection();
		CallableStatement stmt = null;
		ArrayList<recharge> ar_reslt=new ArrayList<recharge>();
		ResultSet rs;
		int i=4;
		if(c!=null){
			String query = "{CALL doPopulateRechargeResult(?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setString(1, obj.get_cusid());
				rs=stmt.executeQuery();
				while (rs.next()) {
					recharge obj_value=new recharge();
					obj_value.set_amt(rs.getInt("amt"));
					obj_value.set_cuoponcode(rs.getString("couponcode"));
					obj_value.set_cusid(rs.getString("cusid"));
					obj_value.set_mno(rs.getInt("mno"));
					obj_value.set_operetaor(rs.getString("operator"));
					obj_value.set_status(rs.getInt("status"));
					ar_reslt.add(obj_value);
					}
				stmt.close();
				c.close();
				
			}catch (SQLException e) {
				return null;
			}
		}
		
		return ar_reslt;
	}

	public boolean updateStatus(int status, String tranid) {
		Connection c = null;
		c=DBconnect.getConnection();
		CallableStatement stmt = null;
		int rs=3;
		if(c!=null){
			String query = "{CALL doUpdtRecharge(?,?)}";
			try {
				stmt = c.prepareCall(query);
				stmt.setInt(1, status);
				stmt.setString(2, tranid);
				
				rs=stmt.executeUpdate();
				stmt.close();
				c.close();
			}catch (Exception e) {
				return false;
			}
		}
		return (rs==0)?true:false;
	}

	public String generateTranid() {
		// TODO Auto-generated method stub
		return null;
	}

}
