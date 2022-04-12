package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.mainbanner.MainBannerVO;

public class MainBannerDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;	
	
	public List<MainBannerVO> selectMainBannerList() {
		List<MainBannerVO> mainBannerList = new ArrayList<MainBannerVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from main_banner_table;";
			
			preparedStatement = connection.prepareStatement(sql);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				MainBannerVO mainBannerVO = new MainBannerVO();
				
				mainBannerVO.setMainBannerIndex(resultSet.getInt("main_banner_index"));
				mainBannerVO.setImageFile(resultSet.getString("image_file"));
				mainBannerVO.setLink(resultSet.getString("link"));
				
				mainBannerList.add(mainBannerVO);				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(resultSet != null) {
					resultSet.close();
				}
				if(preparedStatement != null) {
					preparedStatement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return mainBannerList;
	}

}
