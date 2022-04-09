package com.uphill.web.viewresolver;

public class ViewResolver {
	private String path;
	private String data;
	private boolean isRedirect;
	
	public ViewResolver() {
		super();
	}
	
	public ViewResolver(String path) {
		super();
		this.path = path;
		this.isRedirect = false;
	}

	public ViewResolver(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}
	
	public String getPath() {
		return path;
	}
	
	public boolean getIsRedirect() {
		return isRedirect;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
}
