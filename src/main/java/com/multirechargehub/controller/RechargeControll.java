package com.multirechargehub.controller;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.multirechargehub.model.recharge;
import com.multirechargehub.service.RechargeServiceImpl;
import com.multirechargehub.utils.util;

@Path("/recharge")
public class RechargeControll {
	@GET
	@Path("/doRecharge")
	@Produces(MediaType.APPLICATION_JSON) 
	public String doRecharge(){
		RechargeServiceImpl rchrObj=new RechargeServiceImpl();
		recharge r=new recharge();
		String response="";
		r.set_mno(234335);
		r.set_amt(300);
		r.set_cusid("2hhj");
		r.set_operetaor("Airtel");
		r.set_status(2);
		r.set_trnid(util.generateTransactionId());
		r.set_cuoponcode("dss2s");
		if(rchrObj.insertDB(r)){
			if(rchrObj.doRecharge(r)){
				if(rchrObj.updateStatus(r.get_status(), r.get_trnid())){
				
				response=util.constructJSON("recharge", true,"Successfull !!");
				}else{
					response=util.constructJSON("recharge", false,"Error Try Again !!");

				}

			}else{
				response=util.constructJSON("recharge", false,"Error Try Again !!");

			}

		}else{
			response=util.constructJSON("recharge", false,"Error Try Again !!");

		}
		
		
		return response;
		
	}
	@GET
	@Path("/doPopulate")
	@Produces(MediaType.APPLICATION_JSON) 
	public ArrayList<recharge> doPopulate(){
		RechargeServiceImpl rchrObj=new RechargeServiceImpl();
		recharge r=new recharge();
	
		r.set_cusid("2hhj");
	
		return rchrObj.populate(r);
		
	}

}
