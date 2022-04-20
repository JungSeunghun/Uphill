package com.uphill.web.action.account;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.uphill.web.action.Action;
import com.uphill.web.viewresolver.ViewResolver;

public class CheckSecureCodeAction implements Action {

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
		String secureCode = jsonObject.getString("secureCode");		
		
		ViewResolver viewResolver = new ViewResolver();
		
		HttpSession session = request.getSession();
		
		if(secureCode.equals(session.getAttribute("secureCode"))) { // secureCode가 동일할 경우
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isSecureCodeCheck", "true");
			viewResolver.setData(sendJsonObject.toString());
		} else { // secureCode가 동일하지 않을 경우
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isSecureCodeCheck", "false");
			viewResolver.setData(sendJsonObject.toString());
		}		
		
		return viewResolver;
	}

}
