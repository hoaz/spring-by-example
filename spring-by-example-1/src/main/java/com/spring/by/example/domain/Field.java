package com.spring.by.example.domain;

public enum Field {
	
	QA ("Quality Assurance"),WAD("Web Application Developement"),EMBEDDED ("Embedded developement"),MOBILE("Mobile Platforms Development");
	
	private final String fullName;
	
	Field(String fulllName) {
		this.fullName = fulllName;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	@Override
	public String toString() {		
		return getFullName();
	}

}
