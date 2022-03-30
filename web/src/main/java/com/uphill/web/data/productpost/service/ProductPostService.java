package com.uphill.web.data.productpost.service;

import java.util.List;

import com.uphill.web.data.productpost.dto.ProductPostVO;

public interface ProductPostService {
	List<ProductPostVO> getProductPostList();
	ProductPostVO getProductPost(int productPost);
	boolean registProductPost(ProductPostVO productPostVO);
	boolean updateProductPost(ProductPostVO productPostVO);
	boolean deleteProductPost(ProductPostVO productPostVO);
}
