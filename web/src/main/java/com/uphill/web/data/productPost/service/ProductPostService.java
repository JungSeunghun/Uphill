package com.uphill.web.data.productPost.service;

import java.util.List;

import com.uphill.web.data.productPost.dto.ProductPostVO;

public interface ProductPostService {
	List<ProductPostVO> getAllProductPosts();
	ProductPostVO getProductPost(int productPost);
	boolean registProductPost(ProductPostVO productPostVO);
	boolean updateProductPost(ProductPostVO productPostVO);
	boolean deleteProductPost(ProductPostVO productPostVO);
}
