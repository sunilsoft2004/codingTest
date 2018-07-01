package com.dto;

public class Bolt extends Parts {	
	private int id;
	private String desc;
	
	public Bolt(int id, String desc) {
		super();
		this.id = id;
		this.desc = desc;
	}

	public int getId() {
		return id;
	}

	public String getDesc() {
		return desc;
	}

	@Override
	public String toString() {
		return "Bolt [id=" + id + ", desc=" + desc + "]";
	}
	
	
	
	
}
