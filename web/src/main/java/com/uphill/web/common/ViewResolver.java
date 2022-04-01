package com.uphill.web.common;

public class ViewResolver {
	private String path = "";	
	private boolean isRedirect = false;
	
	private final String prefix = "/WEB-INF/views";
	private final String suffix = ".jsp";
	
	public ViewResolver() {}
	
	/*
	 * isRedirect는 false가 기본값
	 */
	public ViewResolver(String path) {
		super();
		this.path = path;
	}
	
	/*
	 * isRedirect가 true면 redirect
	 * isRedirect가 false면 forward
	 */
	public ViewResolver(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		if(path.endsWith(".up")) {
			return path;
		}
		
		return prefix + path + suffix;
	}

	public boolean isRedirect() {
		return isRedirect;
	}
}
