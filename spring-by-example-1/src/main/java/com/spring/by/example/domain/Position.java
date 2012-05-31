package com.spring.by.example.domain;

public enum Position {	
	
	ASSOCIATE("Associate"), MIDLEVEL("Midlevel") , SENIOR("Senior");
	
	private static final String SWE = "Software Engineer";
	
	private final String fullName;
	
	Position(String fullName) {
		this.fullName = fullName;
	}
	
	public String getFullName() {
		return fullName + " " + SWE;
	}
	
	@Override
	public String toString() {		
		return getFullName();
	}

}
