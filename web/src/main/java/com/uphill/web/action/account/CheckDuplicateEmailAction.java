package com.uphill.web.action.account;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import com.uphill.web.action.Action;
import com.uphill.web.service.account.CheckDuplicateEmailService;
import com.uphill.web.service.account.CheckDuplicateIdService;
import com.uphill.web.util.Email;
import com.uphill.web.util.SHA256Encoder;
import com.uphill.web.viewresolver.ViewResolver;

public class CheckDuplicateEmailAction implements Action {

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
		String email = jsonObject.getString("email");		
		
		CheckDuplicateEmailService checkDuplicateEmailService = new CheckDuplicateEmailService();
		boolean result = checkDuplicateEmailService.checkDuplicateEmailService(email);		
		
		ViewResolver viewResolver = new ViewResolver();
		if(result) { // 이미 존재하는 이메일일 경우
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isDuplicateEmail", "true");
			viewResolver.setData(sendJsonObject.toString());
		} else { // 존재하지 않는 이메일일 경우
			JSONObject sendJsonObject = new JSONObject();
			sendJsonObject.append("isDuplicateEmail", "false");
			viewResolver.setData(sendJsonObject.toString());
			
			String secureCode = SHA256Encoder.getRandomPassword(8);
			
			HttpSession session = request.getSession();
			session.setAttribute("secureCode", secureCode);
			
			String subject = "Up-Hill 보안코드";
			String content = "secureCode : " + secureCode;
			
			Email.sendEmail(email, subject, content);
		}		
	
		return viewResolver;
	}

}
