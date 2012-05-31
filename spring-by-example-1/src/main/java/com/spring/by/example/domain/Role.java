package com.spring.by.example.domain;

public enum Role {
	
	DEV("Developer"),TL("Team Lead"),CM("Customer Manager");
	
	private final String fullName;
	
	Role(String fulllName) {
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
