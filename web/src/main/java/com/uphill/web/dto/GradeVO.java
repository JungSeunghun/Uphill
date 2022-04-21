package com.uphill.web.dto;

public class GradeVO {
	private int gradeIndex;
	private String gradeType;
	private int gradePurchase;
	private int savePercent;
	
	public GradeVO() {
		super();
	}

	public GradeVO(int gradeIndex, String gradeType, int gradePurchase, int savePercent) {
		super();
		this.gradeIndex = gradeIndex;
		this.gradeType = gradeType;
		this.gradePurchase = gradePurchase;
		this.savePercent = savePercent;
	}

	public int getGradeIndex() {
		return gradeIndex;
	}

	public void setGradeIndex(int gradeIndex) {
		this.gradeIndex = gradeIndex;
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
