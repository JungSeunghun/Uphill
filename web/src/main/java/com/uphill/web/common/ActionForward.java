package com.uphill.web.common;

public class ActionForward {
	private String path = "";	
	private boolean isRedirect = false;
	
	private final String prefix = "/WEB-INF/views";
	private final String suffix = ".jsp";
	
	public ActionForward() {}
	
	/*
	 * isRedirect는 false가 기본값
	 */
	public ActionForward(String path) {
		super();
		this.path = path;
	}
	
	/*
	 * isRedirect가 true면 redirect
	 * isRedirect가 false면 forward
	 */
	public ActionForward(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return prefix + path + suffix;
	}

	public boolean isRedirect() {
		return isRedirect;
	}
}
