package com.uphill.web.viewresolver;

public class ViewResolver {
	private String path;
	private boolean isRedirect;
		
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
	
}
