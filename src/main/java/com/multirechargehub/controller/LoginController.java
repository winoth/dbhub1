package com.multirechargehub.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.multirechargehub.service.LoginServiceImpl;
import com.multirechargehub.utils.util;

@Path("/login")
public class LoginController {
	
	@GET 
	// Path: http://localhost/<appln-folder-name>/login/dologin
	@Path("/dologin")
	// Produces JSON as response
	@Produces(MediaType.APPLICATION_JSON) 
	public String doLogin(@QueryParam("value1") String uname,
			@QueryParam("value2") String pwd){
		String response="";
		boolean flag=false;
		LoginServiceImpl loginObj=new LoginServiceImpl();
		flag=(loginObj.checkCredentials(uname, pwd)?true:false);
		if(flag){
		response=util.constructJSON("login", "success");
		}else{
			response=util.constructJSON("login", "failed");

		}
		return response;
	}
	@GET
	@Path("/checkAnswer")
	@Produces(MediaType.APPLICATION_JSON) 
	public String doCheckAnswer(@QueryParam("mno") int mno,
			@QueryParam("answer") String ans){
		
		String response="";
		LoginServiceImpl loginObj=new LoginServiceImpl();
		
		String cid=loginObj.getCustomerId(mno);
		
		if(cid!=null){
			if(loginObj.getPwdResetAnswer(cid).equals(ans)){
				response=util.constructJSON("answer", true,cid);
			}else{
				response=util.constructJSON("answer", false,"no matches found try again!!");

			}
		}else{
			response=util.constructJSON("answer", false,"The mobile no is not available!!");
		}
		return response;
				
		
	}
	
	@GET
	@Path("/doResetPwd")
	@Produces(MediaType.APPLICATION_JSON)
	public String doResetPwd(@QueryParam("cid") String cid,
			@QueryParam("pwd") String pwd){
		String response="";
		LoginServiceImpl loginObj=new LoginServiceImpl();
		if(loginObj.pwdReset(cid, pwd)){
			response=util.constructJSON("pwd", true,"Updated sucessfully!!");
		}else{
			response=util.constructJSON("pwd", false,"Error in update try again!!");
		}
				return response;
		
	}
	
}
