package com.uphill.web.data.afterservice.service;

import java.util.List;

import com.uphill.web.data.afterservice.dto.AfterServiceVO;

public interface AfterServiceService {
	List<AfterServiceVO> getAfterServiceList();
	AfterServiceVO getAfterService(int afterServiceId);
	boolean registAfterService(AfterServiceVO afterServiceVO);
	boolean updateAfterService(AfterServiceVO afterServiceVO);
	boolean deleteAfterService(AfterServiceVO afterServiceVO);
	
}
