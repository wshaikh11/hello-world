package com.afour.recruitment.model;

public enum RequirementStatus {
	OPEN("open"), CLOSED("closed");
	private final String myEnumType;

	private RequirementStatus(String myEnumType) {
		this.myEnumType = myEnumType;
	}

	public boolean equalsType(String myOtherEnumType) {
		return myOtherEnumType != null && myEnumType.equals(myOtherEnumType);
	}

	@Override
	public String toString() {
		return this.myEnumType;
	}
}
