package com.uphill.web.data.member.service;

import java.util.List;

import com.uphill.web.data.member.dto.MemberVO;

public interface MemberService {
	List<MemberVO> getMemberList();
	MemberVO getMember(int userId);
	MemberVO getMember(String userEnterId);
	boolean registMember(MemberVO memberVO);
	boolean updateMember(MemberVO memberVO);
	boolean deleteMember(MemberVO memberVO);
}
