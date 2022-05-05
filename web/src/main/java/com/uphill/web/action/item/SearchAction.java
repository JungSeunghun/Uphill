package com.uphill.web.action.item;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import com.uphill.web.action.Action;
import com.uphill.web.service.item.ItemService;
import com.uphill.web.service.item.ItemServiceImpl;
import com.uphill.web.viewresolver.ViewResolver;

public class SearchAction implements Action {

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
		String search = jsonObject.getString("search");	
		
		ItemService itemService = new ItemServiceImpl();
		List<String> searchNameList = itemService.getSearchNameList(search);
		
		JSONObject sendJsonObject = new JSONObject();
		sendJsonObject.append("searchNameList", searchNameList);
		
		ViewResolver viewResolver = new ViewResolver();
		viewResolver.setData(sendJsonObject.toString());
		
		return viewResolver;
	}

}
