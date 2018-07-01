package com.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import com.dto.Bolt;
import com.dto.Machiene;
import com.dto.Parts;
import com.listener.QueueListener;
import com.supply.SupplyMgmt;

public class Main {

	public static void main(String[] args) {

		Queue<Parts> queue = new ConcurrentLinkedQueue<Parts>();
		
		SupplyMgmt supplyMgmt = new SupplyMgmt(queue);

		List<Parts> parts = getParts(1000);
		supplyMgmt.incomingParts(parts);
		
		//start processing -->read/product
		QueueListener queueListener = new QueueListener(queue);
		queueListener.start();
	}

	private static List<Parts> getParts(int numOfParts) {
		List<Parts> list = new ArrayList<Parts>();

		int id = 0;
		String desc = "desc";

		for (int i = 0; i < numOfParts; i++) {
			list.add(new Bolt(id, desc));
			list.add(new Bolt(id, desc));
			list.add(new Machiene(id, desc));
			id++;
		}
		return list;
	}

}
