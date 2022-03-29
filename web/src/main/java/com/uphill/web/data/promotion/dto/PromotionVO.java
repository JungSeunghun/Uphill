package com.uphill.web.data.promotion.dto;

public class PromotionVO {
	private int promotionId;
	private String imageFile;
	
	public PromotionVO() {}
	
	public PromotionVO(int promotionId, String imageFile) {
		super();
		this.promotionId = promotionId;
		this.imageFile = imageFile;
	}

	public int getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(int promotionId) {
		this.promotionId = promotionId;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	
}
