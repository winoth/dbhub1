package com.multirechargehub.service;

import java.util.ArrayList;

import com.multirechargehub.model.recharge;

public interface RechargeService {
	public boolean doRecharge(recharge obj);
	public boolean insertDB(recharge obj);
	public ArrayList<recharge> populate(recharge obj);
	public boolean updateStatus(int status,String tranid);
	public String generateTranid();

}
