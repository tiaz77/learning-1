package inheritance;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import ch.gmtech.learning.inheritance.MonitorableQueue;

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
