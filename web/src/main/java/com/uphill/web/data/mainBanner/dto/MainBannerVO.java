package com.uphill.web.data.mainBanner.dto;

public class MainBannerVO {
	private int mainBannerId;
	private String imageFile;
	
	public MainBannerVO() {}
	
	public MainBannerVO(int mainBannerId, String imageFile) {
		super();
		this.mainBannerId = mainBannerId;
		this.imageFile = imageFile;
	}

	public int getMainBannerId() {
		return mainBannerId;
	}

	public void setMainBannerId(int mainBannerId) {
		this.mainBannerId = mainBannerId;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}
	
	
	
	
}
