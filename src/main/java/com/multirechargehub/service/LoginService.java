package com.multirechargehub.service;



public interface LoginService {
	public boolean checkCredentials(String uname, String pwd);
	public boolean pwdReset(String cusid,String newpw);
	public String getMailid(String cusid);
	public String getPwdResetAnswer(String cusid);
	public String getCustomerId(int mno);
	
	

}
