package edu.acc.java;

import java.io.Serializable;

public class HeaderBean implements Serializable {
	// Holds JSP data for EL access
	// Used in ServletG
	
	private String host;
	private String userAgent;
	private String accept;
	
	public HeaderBean() {
		this.host = "";
		this.userAgent = "";
		this.accept = "";
	}
	
	public HeaderBean(String host, String userAgent, String accept) {
		this.host = host;
		this.userAgent = userAgent;
		this.accept = accept;
	}

	public String getHost() {
		return this.host;
	}
	
	public void setHost(String val) {
		this.host = val;
	}

	public String getUserAgent() {
		return this.userAgent;
	}
	
	public void setUserAgent(String val) {
		this.userAgent = val;
	}

	public String getAccept() {
		return accept;
	}

	public void setAccept(String accept) {
		this.accept = accept;
	}

}
