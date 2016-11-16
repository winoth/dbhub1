package com.multirechargehub.service;

import com.multirechargehub.model.register;

public interface RegisterService {
	public boolean doRegister(register obj);
	public boolean doReSentOtp(String cid);
	public boolean doCheckOtp(String cid,String otp);
	
	public String generateOTP();
	public String generateTranid();
	public String generateCusid();
	

	
}
