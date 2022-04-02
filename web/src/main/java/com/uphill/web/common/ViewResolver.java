package com.uphill.web.common;

public class ViewResolver {
	private String path = "";	
	private boolean isCommand = false;
	
	private final String prefix = "/WEB-INF/views/";
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
	public ViewResolver(String path, boolean isCommand) {
		super();
		this.path = path;
		this.isCommand = isCommand;
	}

	public String getPath() {
		if(isCommand) {
			return path;
		}
		return prefix + path + suffix;
	}

	public boolean isCommand() {
		return isCommand;
	}
}
