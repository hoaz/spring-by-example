package com.spring.by.example.domain;

public enum Technology {
	
	JAVA ("Java"), DOTNET(".Net"), PHP("PHP");
	
	private final String fullName;
	
	Technology(String fulllName) {
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
