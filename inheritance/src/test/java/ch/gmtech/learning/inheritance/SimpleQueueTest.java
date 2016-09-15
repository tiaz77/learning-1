package inheritance;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import ch.gmtech.learning.inheritance.SimpleQueue;

public class SimpleQueueTest {

	@Test
	public void newQueueIsEmpty() {
		SimpleQueue queue = new SimpleQueue();

		assertTrue(queue.isEmpty());
	}
	
	@Test
	public void dequeueReturnsFirstElement() {
		
		SimpleQueue queue = new SimpleQueue();
		queue.enqueue(1);
		queue.enqueue(2);
		
		SimpleQueue expected = new SimpleQueue();
		expected.enqueue(2);

		assertEquals(1, queue.dequeue());
		assertEquals(expected, queue);
	}
	
	@Test
	public void peekDoesNotRemoveAnyElement() {
		
		SimpleQueue queue = new SimpleQueue();
		queue.enqueue(1);
		
		SimpleQueue expected = new SimpleQueue();
		expected.enqueue(1);

		assertEquals(1, queue.peek());
		assertEquals(expected, queue);
		assertFalse(queue.isEmpty());
	}
	
	@Test
	public void dequeueAndPeekReturnNullOnEmptyQueue() {
		
		SimpleQueue queue = new SimpleQueue();

		assertEquals(null, queue.peek());
		assertEquals(null, queue.dequeue());
	}
	
}