package com.process;

import java.util.concurrent.BlockingQueue;

import com.dto.Bolt;
import com.dto.Machiene;
import com.queue.process.Processor;
import com.queue.process.ProductProcessor;

public class ProductThread implements Runnable {

	private BlockingQueue<Bolt> boltLinkedBlockingQueue;
	private BlockingQueue<Machiene> machieneLinkedBlockingQueue;
	private Processor processor;

	public ProductThread(BlockingQueue<Bolt> boltLinkedBlockingQueueP,
			BlockingQueue<Machiene> machieneLinkedBlockingQueueP) {
		boltLinkedBlockingQueue = boltLinkedBlockingQueueP;
		machieneLinkedBlockingQueue = machieneLinkedBlockingQueueP;
		processor = new ProductProcessor();
	}

	public void run() {
		while (true) {
			Bolt bolt1 = null;
			Bolt bolt2 = null;
			Machiene machiene = null;
			try {
				bolt1 = boltLinkedBlockingQueue.take();
				bolt2 = boltLinkedBlockingQueue.take();
				machiene = machieneLinkedBlockingQueue.take();

			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			processor.process(bolt1, bolt2, machiene);
		}

	}

}
