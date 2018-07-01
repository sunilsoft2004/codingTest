package com.dto;

public class Machiene  extends Parts {
	
	private int id;
	private String desc;

	public Machiene(int id, String desc) {
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
		return "Machiene [id=" + id + ", desc=" + desc + "]";
	}
	
	
}
