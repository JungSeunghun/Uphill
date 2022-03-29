package com.uphill.web.data.notice.service;

import java.util.List;

import com.uphill.web.data.notice.dto.NoticeVO;

public interface NoticeService {
	List<NoticeVO> getAllNotices();
	NoticeVO getNotice(int noticeId);
	boolean registNotice(NoticeVO noticeVO);
	boolean updateNotice(NoticeVO noticeVO);
	boolean deleteNotice(NoticeVO noticeVO);
}
