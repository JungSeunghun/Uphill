package com.uphill.web.data.information.service;

import java.util.List;

import com.uphill.web.data.information.dto.InformationVO;

public interface InformationService {
	List<InformationVO> getInformationList();
	InformationVO getInformation(int informationId);
	boolean registInformation(InformationVO informationVO);
	boolean updateInformation(InformationVO informationVO);
	boolean deleteInformation(InformationVO informationVO);
	
}
