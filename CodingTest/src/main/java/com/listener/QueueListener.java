package com.listener;

import java.util.Queue;

import com.dto.Parts;
import com.queue.mgr.QueueMgr;

public class QueueListener implements Listener {
	private Queue<Parts> queue = null;

	public QueueListener(Queue<Parts> queue) {
		this.queue = queue;
	}

	public void start() {
		while (true) {
			Parts parts = queue.poll();
			if (parts == null)	break;
			QueueMgr.getInstance().processParts(parts);
		}
	}

}
