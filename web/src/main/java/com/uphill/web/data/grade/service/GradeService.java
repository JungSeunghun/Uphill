package com.uphill.web.data.grade.service;

import java.util.List;

import com.uphill.web.data.grade.dto.GradeVO;

public interface GradeService {
	List<GradeVO> getAllGrades();
	GradeVO getGrade(int gradeId);
	boolean registGrade(GradeVO gradeVO);
	boolean updateGrade(GradeVO gradeVO);
	boolean deleteGrade(GradeVO gradeVO);
}
