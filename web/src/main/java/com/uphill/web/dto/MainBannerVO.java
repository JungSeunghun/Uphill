package com.uphill.web.dto;

public class MainBannerVO {
	private int mainBannerIndex;
	private String imageFile;
	private String link;
	
	public MainBannerVO() {
		super();
	}

	public MainBannerVO(int mainBannerIndex, String imageFile, String link) {
		super();
		this.mainBannerIndex = mainBannerIndex;
		this.imageFile = imageFile;
		this.link = link;
	}

	public int getMainBannerIndex() {
		return mainBannerIndex;
	}

	public void setMainBannerIndex(int mainBannerIndex) {
		this.mainBannerIndex = mainBannerIndex;
	}

	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
	
}
