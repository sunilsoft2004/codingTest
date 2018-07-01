package com.supply;

import java.util.List;
import java.util.Queue;

import com.dto.Parts;

public class SupplyMgmt {
	private Queue<Parts> queue = null;
	
	public SupplyMgmt(Queue<Parts> queue) {
		this.queue = queue;
	}
	
	public void incomingParts(List<Parts> parts) {
		
		for (Parts parts2 : parts) {
			queue.add(parts2);
		}
	}
	

}
