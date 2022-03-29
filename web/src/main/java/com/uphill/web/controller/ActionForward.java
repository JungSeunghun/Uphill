package com.uphill.web.controller;

public class ActionForward {
	private String path = "";
	
	private boolean isRedirect = false;
	
	public ActionForward() {}
	
	public ActionForward(String path) {
		super();
		this.path = path;
	}
	
	public ActionForward(String path, boolean isRedirect) {
		super();
		this.path = path;
		this.isRedirect = isRedirect;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public boolean isRedirect() {
		return isRedirect;
	}

	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	}
}
