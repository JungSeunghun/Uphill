package com.uphill.web.data.grade.dto;

public class GradeVO {
	private int gradeId;
	private String gradeType;
	private int gradePurchase;
	private int savePercent;
	
	public GradeVO() {}
	
	public GradeVO(int gradeId, String gradeType, int gradePurchase, int savePercent) {
		super();
		this.gradeId = gradeId;
		this.gradeType = gradeType;
		this.gradePurchase = gradePurchase;
		this.savePercent = savePercent;
	}

	public int getGradeId() {
		return gradeId;
	}

	public void setGradeId(int gradeId) {
		this.gradeId = gradeId;
	}

	public String getGradeType() {
		return gradeType;
	}

	public void setGradeType(String gradeType) {
		this.gradeType = gradeType;
	}

	public int getGradePurchase() {
		return gradePurchase;
	}

	public void setGradePurchase(int gradePurchase) {
		this.gradePurchase = gradePurchase;
	}

	public int getSavePercent() {
		return savePercent;
	}

	public void setSavePercent(int savePercent) {
		this.savePercent = savePercent;
	}
	
	
}
