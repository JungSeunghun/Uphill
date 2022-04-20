package com.uphill.web.service.item;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.uphill.web.database.mybatis.MybatisSessionFactory;
import com.uphill.web.dto.ItemOptionVO;
import com.uphill.web.dto.ItemPostInfoVO;
import com.uphill.web.dto.ItemPostVO;
import com.uphill.web.dto.ItemVO;

public class ItemServiceImpl implements ItemService{
	private SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
	private ItemMapper itemMapper = sqlSession.getMapper(ItemMapper.class);
	
	@Override
	public ItemVO getItem(int itemIndex) {
		ItemVO itemVO = itemMapper.selectItem(itemIndex);
		sqlSession.close();
		
		return itemVO;
	}

	@Override
	public List<ItemVO> getItemList() {
		List<ItemVO> itemList = itemMapper.selectItemList();
		sqlSession.close();
		
		return itemList;
	}

	@Override
	public List<ItemVO> getItemListWithCategory(int categoryIndex) {
		List<ItemVO> itemList = itemMapper.selectItemListWithCategory(categoryIndex);
		sqlSession.close();
		
		return itemList;
	}

	@Override
	public List<ItemVO> getBicycleList() {
		List<ItemVO> bicycleList = itemMapper.selectBicycleList();
		sqlSession.close();
		
		return bicycleList;
	}

	@Override
	public List<ItemVO> getBicycleListWithSubcategory(int subcategoryIndex) {
		List<ItemVO> bicycleList = itemMapper.selectBicycleListWithSubcategory(subcategoryIndex);
		sqlSession.close();
		
		return bicycleList;
	}

	@Override
	public ItemPostInfoVO getItemPost(int itemIndex) {
		ItemPostVO itemPostVO = itemMapper.selectItemPost(itemIndex);
		List<ItemOptionVO> itemOptionList = itemMapper.selectItemOptionList(itemIndex);
		ItemVO itemVO = itemMapper.selectItem(itemIndex);
		
		ItemPostInfoVO itemPostInfoVO = new ItemPostInfoVO(itemPostVO, itemOptionList, itemVO);
		
		sqlSession.close();
		
		return itemPostInfoVO;
	}

	@Override
	public List<ItemOptionVO> getItemOptionList(int itemIndex) {
		List<ItemOptionVO> itemOptionList = itemMapper.selectItemOptionList(itemIndex);
		sqlSession.close();
		
		return itemOptionList;
	}	
}
