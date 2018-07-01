package com.queue.process;


import com.dto.Bolt;
import com.dto.Machiene;

public class ProductProcessor implements Processor{

	public void process(Bolt bolt1, Bolt bolt2,Machiene machiene) {
		System.out.println("Product created using bolt1 :"+bolt1);
		System.out.println("Product created using bolt2 :"+bolt2);
		System.out.println("Product created using machiene :"+machiene);
		try {
			Thread.sleep(60);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
