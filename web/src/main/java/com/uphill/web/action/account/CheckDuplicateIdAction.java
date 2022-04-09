package com.uphill.web.action.account;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.uphill.web.action.Action;
import com.uphill.web.service.account.CheckDuplicateIdService;
import com.uphill.web.viewresolver.ViewResolver;

public class CheckDuplicateIdAction implements Action {

	@Override
	public ViewResolver execute(HttpServletRequest request, HttpServletResponse response) {
		
		StringBuffer buffer = new StringBuffer();
		String line = null;
		
		try {
			BufferedReader reader = request.getReader();
			while ((line = reader.readLine()) != null) {
				buffer.append(line);				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		JSONObject jsonObject = new JSONObject(buffer.toString());
		String userEnterId = jsonObject.getString("userEnterId");		
		
		CheckDuplicateIdService checkDuplicateIdService = new CheckDuplicateIdService();
		boolean result = checkDuplicateIdService.checkDuplicateIdService(userEnterId);		
		
		ViewResolver viewResolver = new ViewResolver();
		if(result) {
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isDuplicateId", "true");
			viewResolver.setData(sendJsonObject.toString());
		} else {
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isDuplicateId", "false");
			viewResolver.setData(sendJsonObject.toString());
		}		
		
		return viewResolver;
	}

}
