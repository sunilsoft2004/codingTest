package com.queue.process;

import com.dto.Bolt;
import com.dto.Machiene;

public interface Processor {
	void process(Bolt bolt1, Bolt bolt2,Machiene machiene);
}
