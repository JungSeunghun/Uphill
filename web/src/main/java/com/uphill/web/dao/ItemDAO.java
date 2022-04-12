package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.item.ItemVO;

public class ItemDAO {
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;
	private ResultSet resultSet = null;
	
	public List<ItemVO> selectBestSellerList(int categoryIndex, int count) {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from (select rank() over(order by item_sell_count desc, item_price desc) as ranking, item_table.* from item_table where item_total_qty != 0 and item_category_index = ?) as bestseller where ranking <= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, categoryIndex);
			preparedStatement.setInt(2, count);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				ItemVO itemVO = new ItemVO();
				
				itemVO.setItemIndex(resultSet.getInt("item_index"));
				itemVO.setItemCategoryIndex(resultSet.getInt("item_category_index"));
				itemVO.setItemSubcategoryIndex(resultSet.getInt("item_subcategory_index"));
				itemVO.setItemName(resultSet.getString("item_name"));
				itemVO.setItemImage(resultSet.getString("item_image"));
				itemVO.setItemDiscountPrice(resultSet.getInt("item_discount_price"));
				itemVO.setItemTotalQty(resultSet.getInt("item_total_qty"));
				itemVO.setItemSellCount(resultSet.getInt("item_sell_count"));
				
				itemList.add(itemVO);				
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
		
		return itemList;
	}
	
	public List<ItemVO> selectBestItemList(int count) {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from (select rank() over(order by item_sell_count desc, item_price desc) as ranking, item_table.* from item_table where item_total_qty != 0 and item_category_index != 1) as bestseller where ranking <= ?;";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, count);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				ItemVO itemVO = new ItemVO();
				
				itemVO.setItemIndex(resultSet.getInt("item_index"));
				itemVO.setItemCategoryIndex(resultSet.getInt("item_category_index"));
				itemVO.setItemSubcategoryIndex(resultSet.getInt("item_subcategory_index"));
				itemVO.setItemName(resultSet.getString("item_name"));
				itemVO.setItemImage(resultSet.getString("item_image"));
				itemVO.setItemDiscountPrice(resultSet.getInt("item_discount_price"));
				itemVO.setItemTotalQty(resultSet.getInt("item_total_qty"));
				itemVO.setItemSellCount(resultSet.getInt("item_sell_count"));
				
				itemList.add(itemVO);				
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
		
		return itemList;
	}
	
}
