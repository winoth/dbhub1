package com.multirechargehub.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.multirechargehub.model.register;
import com.multirechargehub.service.RegisterServiceImpl;
import com.multirechargehub.utils.util;

@Path("/register")
public class RegisterController {
	@GET
	@Path("/doRegister")
	@Produces(MediaType.APPLICATION_JSON) 
	public String doRegister(
			@QueryParam("fname") String fname,
			@QueryParam("email") String email,
			@QueryParam("uname") int uname,
			@QueryParam("pwd") String pwd,
			@QueryParam("question") String qus,
			@QueryParam("answer") String ans,
			@QueryParam("imei") String imei
			){
		String response;
		RegisterServiceImpl regObj=new RegisterServiceImpl();
		register reg=new register();
		reg.set_fname("sara");
		reg.set_email("some@gmail.com");
		reg.set_uname(22121);
		reg.set_pwd("1234");
		reg.set_question("somthing");
		reg.set_answer("nothing");
		reg.set_status(1);
		reg.set_imei("121ssdsd");
		
		reg.set_otp(regObj.generateOTP());
		reg.set_cusid(regObj.generateCusid());
		reg.set_tranid(regObj.generateTranid());
		if(regObj.doRegister(reg)){
			response=util.constructJSON("registration", true,"Successfull !!");

		}else{
			response=util.constructJSON("registration", false,"Error Try Again !!");

		}
		return response;
		
	}
	
	@GET
	@Path("/doResendOtp")
	@Produces(MediaType.APPLICATION_JSON) 
	public String doSendOtp(
			@QueryParam("cid") String cid){
		RegisterServiceImpl regObj=new RegisterServiceImpl();
		String response="";
		if(regObj.doReSentOtp(cid)){
			response=util.constructJSON("reSentotp", true,"Successfull !!");

		}else{
			response=util.constructJSON("reSentotp", false,"Error Try Again !!");

		}
		return response;
	}
	@GET
	@Path("/doCheckOtp")
	@Produces(MediaType.APPLICATION_JSON) 
	public String doCheckOtp(
			@QueryParam("cid") String cid,
			@QueryParam("otp") String notp){
		RegisterServiceImpl regObj=new RegisterServiceImpl();
		String response="";
		if(regObj.doCheckOtp("qjuaRF", "Xv0iid")){
			response=util.constructJSON("otp", true,"A Match found !!");

		}else{
			response=util.constructJSON("otp", false,"No Matches found !!");

		}
		return response;
	}
	
}
