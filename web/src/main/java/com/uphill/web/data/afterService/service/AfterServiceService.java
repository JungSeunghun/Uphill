package com.uphill.web.data.afterService.service;

import java.util.List;

import com.uphill.web.data.afterService.dto.AfterServiceVO;

public interface AfterServiceService {
	List<AfterServiceVO> getAllAfterServices();
	AfterServiceVO getAfterService(int afterServiceId);
	boolean registAfterService(AfterServiceVO afterServiceVO);
	boolean updateAfterService(AfterServiceVO afterServiceVO);
	boolean deleteAfterService(AfterServiceVO afterServiceVO);
	
}
