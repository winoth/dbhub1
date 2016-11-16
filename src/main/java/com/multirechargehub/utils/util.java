package com.multirechargehub.utils;

import java.security.SecureRandom;
import java.util.Random;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;


public class util {
	/**
	 * Null check Method
	 * 
	 * @param txt
	 * @return
	 */
	public static boolean isNotNull(String txt) {
		// System.out.println("Inside isNotNull");
		return txt != null && txt.trim().length() >= 0 ? true : false;
	}

	/**
	 * Method to construct JSON
	 * 
	 * @param tag
	 * @param string
	 * @return
	 */
	public static String constructJSON(String tag, String string) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", string);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return obj.toString();
	}

	/**
	 * Method to construct JSON with Error Msg
	 * 
	 * @param tag
	 * @param status
	 * @param err_msg
	 * @return
	 */
	public static String constructJSON(String tag, boolean status,String err_msg) {
		JSONObject obj = new JSONObject();
		try {
			obj.put("tag", tag);
			obj.put("status", new Boolean(status));
			obj.put("msg", err_msg);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
		}
		return obj.toString(); 
	}

	public static String generateTransactionId(){
		 String chars = "abcdefghijklmnopqrstuvwxyz"
                 + "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                 + "0123456789";

    final int PW_LENGTH = 8;
    Random rnd = new SecureRandom();
    StringBuilder pass = new StringBuilder();
    for (int i = 0; i < PW_LENGTH; i++){
        pass.append(chars.charAt(rnd.nextInt(chars.length())));}
    return pass.toString();
	}
}
