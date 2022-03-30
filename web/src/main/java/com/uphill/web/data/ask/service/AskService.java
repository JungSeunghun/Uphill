package com.uphill.web.data.ask.service;

import java.util.List;

import com.uphill.web.data.ask.dto.AskVO;

public interface AskService {
	List<AskVO> getAskList();
	AskVO getAsk(int askId);
	boolean registAsk(AskVO askVO);
	boolean updateAsk(AskVO askVO);
	boolean deleteAsk(AskVO askVO);	
}
