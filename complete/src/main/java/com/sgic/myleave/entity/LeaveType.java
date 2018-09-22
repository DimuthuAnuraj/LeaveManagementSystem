package com.sgic.myleave.entity;

public class LeaveType {
	private String id;
	private String type;
	private String allocatedDays;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getAllocatedDays() {
		return allocatedDays;
	}
	public void setAllocatedDays(String allocatedDays) {
		this.allocatedDays = allocatedDays;
	}
	
	
}
