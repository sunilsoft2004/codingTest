package com.queue.mgr;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

import com.dto.Bolt;
import com.dto.Machiene;
import com.dto.Parts;
import com.process.ProductThread;

public class QueueMgr {

	private static QueueMgr queueMgr = null;
	private BlockingQueue<Bolt> boltLinkedBlockingQueue = null;
	private BlockingQueue<Machiene> machieneLinkedBlockingQueue = null;

	private QueueMgr() {
		boltLinkedBlockingQueue = new LinkedBlockingQueue<Bolt>();
		machieneLinkedBlockingQueue = new LinkedBlockingQueue<Machiene>();

		ExecutorService executorService = Executors.newFixedThreadPool(3);
		executorService.submit(new ProductThread(boltLinkedBlockingQueue, machieneLinkedBlockingQueue));
		executorService.submit(new ProductThread(boltLinkedBlockingQueue, machieneLinkedBlockingQueue));
		executorService.submit(new ProductThread(boltLinkedBlockingQueue, machieneLinkedBlockingQueue));
	}

	public static QueueMgr getInstance() {
		if (queueMgr == null) {
			queueMgr = new QueueMgr();
		}
		return queueMgr;
	}

	private void addBolt(Bolt parts) {
		boltLinkedBlockingQueue.add(parts);
	}

	private void addMachiene(Machiene parts) {
		machieneLinkedBlockingQueue.add(parts);
	}

	public void processParts(Parts parts) {

		if (parts instanceof Bolt) {
			QueueMgr.getInstance().addBolt((Bolt) parts);
		}

		if (parts instanceof Machiene) {
			QueueMgr.getInstance().addMachiene((Machiene) parts);
		}

	}

}
