package com.uphill.web.action.account;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.uphill.web.action.Action;
import com.uphill.web.service.account.AccountServiceImpl;
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
		String userId = jsonObject.getString("userId");		
		
		AccountServiceImpl userService = new AccountServiceImpl();
		boolean result = userService.checkDuplicateId(userId);		
		
		ViewResolver viewResolver = new ViewResolver();
		if(result) { // 이미 존재하는 아이디일 경우
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isDuplicateId", "true");
			viewResolver.setData(sendJsonObject.toString());
		} else { // 존재하지 않는 아이디일 경우
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isDuplicateId", "false");
			viewResolver.setData(sendJsonObject.toString());
		}		
		
		return viewResolver;
	}

}
