package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.BasketItemVO;
import com.uphill.web.dto.BasketVO;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;

public class BasketDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public int insertBasket(BasketVO basketVO) {
		int result = 0;
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "insert into basket_table values(null, ?, ?, ?, ?, ?)";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, basketVO.getUserIndex());
			preparedStatement.setInt(2, basketVO.getItemIndex());
			preparedStatement.setString(3, basketVO.getOptionName());
			preparedStatement.setInt(4, basketVO.getOptionQty());
			preparedStatement.setInt(5, basketVO.getOptionPrice());
			
			result = preparedStatement.executeUpdate();
			
			if(result > 0) {
				connection.commit();
			} else {
				connection.rollback();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
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
		
		return result;
	}

	public List<BasketItemVO> selectBasketItemList(int userIndex) {
		List<BasketItemVO> basketItemList = new ArrayList<BasketItemVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "SELECT * FROM basket_table join item_table using(item_index) where user_index = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, userIndex);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int basketIndex = resultSet.getInt("basket_index");
				//int userIndex = resultSet.getInt("user_index");
				int itemIndex = resultSet.getInt("item_index");
				String optionName = resultSet.getString("option_name");
				int optionQty = resultSet.getInt("option_qty");
				int optionPrice = resultSet.getInt("option_price");
				int itemCategoryIndex = resultSet.getInt("item_category_index");
				String itemCategoryName = resultSet.getString("item_category_name");
				int itemSubcategoryIndex = resultSet.getInt("item_subcategory_index");
				String itemSubcategoryName = resultSet.getString("item_subcategory_name");
				String itemName = resultSet.getString("item_name");
				String itemImage = resultSet.getString("item_image");
				float starRating = resultSet.getFloat("star_rating");
				int itemPrice = resultSet.getInt("item_price");
				int itemDiscountPrice = resultSet.getInt("item_discount_price");
				int itemTotalQty = resultSet.getInt("item_total_qty");
				int itemSellCount = resultSet.getInt("item_sell_count");
				
				BasketItemVO basketItemVO = new BasketItemVO(basketIndex, userIndex, itemIndex, optionName, optionQty, optionPrice, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty, itemSellCount);
				basketItemList.add(basketItemVO);	
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
		
		return basketItemList;
	}
	
}
