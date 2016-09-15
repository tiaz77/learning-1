package ch.gmtech.learning.inheritance;

import static org.junit.Assert.*;

import org.junit.Test;

public class MonitorableQueueTest {

	@Test
	public void maximumSizeOfEmptyIs0() {
		MonitorableQueue queue = new MonitorableQueue();
		
		assertEquals(0, queue.maximumSize());
	}
	
	@Test
	public void maximumSizeRisesWithEnqueue() {
		MonitorableQueue queue = new MonitorableQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		
		assertEquals(2, queue.maximumSize());
	}

	@Test
	public void maximumSizeRemembersHighWater() {
		MonitorableQueue queue = new MonitorableQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.dequeue();
		
		assertEquals(2, queue.maximumSize());
	}
	
}
