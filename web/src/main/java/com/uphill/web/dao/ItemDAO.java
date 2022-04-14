package com.uphill.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.uphill.web.database.DataBaseUtil;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;

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
			
			while(resultSet.next()) {
				int itemIndex = resultSet.getInt("item_index");
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
				
				ItemVO itemVO = new ItemVO(itemIndex, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty, itemSellCount);
				
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
			String sql = "select * from (select rank() over(order by item_sell_count desc, item_price desc) as ranking, item_table.* from item_table where item_total_qty != 0 and item_category_index != 1) as bestseller where ranking <= ?";
			
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, count);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int itemIndex = resultSet.getInt("item_index");
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
				
				ItemVO itemVO = new ItemVO(itemIndex, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty, itemSellCount);
				
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

	public List<ItemVO> selectItemListExceptCategory(int categoryIndex) {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from item_table where item_category_index != ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, categoryIndex);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int itemIndex = resultSet.getInt("item_index");
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
				
				ItemVO itemVO = new ItemVO(itemIndex, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty, itemSellCount);
				
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
	
	public List<ItemVO> selectItemListWithCategory(int categoryIndex) {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from item_table where item_category_index = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, categoryIndex);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int itemIndex = resultSet.getInt("item_index");
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
				
				ItemVO itemVO = new ItemVO(itemIndex, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty, itemSellCount);
				
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

	public List<ItemVO> selectItemListWithCategoryAndSubcategory(int categoryIndex, int subcategoryIndex) {
		List<ItemVO> itemList = new ArrayList<ItemVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from item_table where item_category_index = ? and item_subcategory_index = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, categoryIndex);
			preparedStatement.setInt(2, subcategoryIndex);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int itemIndex = resultSet.getInt("item_index");
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
				
				ItemVO itemVO = new ItemVO(itemIndex, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty, itemSellCount);
				
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

	public ItemPostVO selectItemPost(int id) {
		ItemPostVO itemPostVO = null;
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from item_post_table where item_index = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int itemPostIndex = resultSet.getInt("item_post_index");
				int itemIndex = resultSet.getInt("item_index");
				String userId = resultSet.getString("user_id");
				Date postDate = resultSet.getDate("post_date");
				String title = resultSet.getString("title");
				String content = resultSet.getString("content");
				String imageFile = resultSet.getString("image_file");
				int hits = resultSet.getInt("hits");
				
				itemPostVO = new ItemPostVO(itemPostIndex, itemIndex, userId, postDate, title, content, imageFile, hits);
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
		
		return itemPostVO;
	}

	public ItemVO selectItem(int id) {
		ItemVO itemVO = null;
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from item_table where item_index = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int itemIndex = resultSet.getInt("item_index");
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
				
				itemVO = new ItemVO(itemIndex, itemCategoryIndex, itemCategoryName, itemSubcategoryIndex, itemSubcategoryName, itemName, itemImage, starRating, itemPrice, itemDiscountPrice, itemTotalQty, itemSellCount);
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
		
		return itemVO;
	}

	public List<String> selectItemOptionNameList(int id) {
		List<String> itemOptionNameList = new ArrayList<String>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "SELECT item_option_name FROM item_option_table where item_index = ? group by item_option_name;";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				String itemOptionName = resultSet.getString("item_option_name");
				
				itemOptionNameList.add(itemOptionName);	
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
		
		return itemOptionNameList;
	}
	
	public List<ItemOptionVO> selectItemOptionList(int id) {
		List<ItemOptionVO> itemOptionList = new ArrayList<ItemOptionVO>();
		
		connection = DataBaseUtil.getConnection();
		
		try {
			String sql = "select * from item_option_table where item_index = ?";
			
			preparedStatement = connection.prepareStatement(sql);
			
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int itemOptionIndex = resultSet.getInt("item_option_index");
				int itemIndex = resultSet.getInt("item_index");
				String itemOptionName = resultSet.getString("item_option_name");
				String itemOptionContent = resultSet.getString("item_option_content");
				int itemOptionPrice = resultSet.getInt("item_option_price");
				int itemOptionQty = resultSet.getInt("item_option_qty");
				
				ItemOptionVO itemOptionVO = new ItemOptionVO(itemOptionIndex, itemIndex, itemOptionName, itemOptionContent, itemOptionPrice, itemOptionQty);
				itemOptionList.add(itemOptionVO);	
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
		
		return itemOptionList;
	}
	
}
