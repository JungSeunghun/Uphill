package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.review.ReviewVO;

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
				ReviewVO reviewVO = new ReviewVO();
				
				reviewVO.setReviewIndex(resultSet.getInt("review_index"));
				reviewVO.setItemPostIndex(resultSet.getInt("item_post_index"));
				reviewVO.setUserId(resultSet.getString("user_id"));
				reviewVO.setPostDate(resultSet.getDate("post_date"));
				reviewVO.setTitle(resultSet.getString("title"));
				reviewVO.setContent(resultSet.getString("content"));
				reviewVO.setStarRating(resultSet.getInt("star_rating"));
				reviewVO.setImageFile(resultSet.getString("image_file"));
				reviewVO.setHits(resultSet.getInt("hits"));
				reviewVO.setRecommend(resultSet.getInt("recommend"));
				
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
