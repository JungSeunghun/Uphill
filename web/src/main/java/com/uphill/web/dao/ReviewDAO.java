package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.ReviewVO;

public class ReviewDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;	
	
	public List<ReviewVO> selectRecentReviewList(int count) {
		List<ReviewVO> reviewList = new ArrayList<ReviewVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from (select rank() over(order by post_date desc, review_index desc) as ranking, review_table.* from review_table) as review where ranking <= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, count);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int reviewIndex = resultSet.getInt("review_index");
				int itemIndex = resultSet.getInt("item_index");
				String userId = resultSet.getString("user_id");
				Date postDate = resultSet.getDate("post_date");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				float starRating = resultSet.getFloat("star_rating");
				String imageFile = resultSet.getString("image_file");
				int hits = resultSet.getInt("hits");
				int recommend = resultSet.getInt("recommend");
				
				ReviewVO reviewVO = new ReviewVO(reviewIndex, itemIndex, userId, postDate, title, content, starRating, imageFile, hits, recommend);

				reviewList.add(reviewVO);				
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
		
		return reviewList;
	}
	
}
