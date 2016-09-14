package ch.gmtech.learning.inheritance;


public class MonitorableQueue implements Queue {

	private final Queue _queue;
	private int _marker;
	
	public MonitorableQueue() {
		_queue = new SimpleQueue();
		_marker = 0;
	}
	
	public void enqueue(Object o) {
		_queue.enqueue(o);
		_marker++;
	}
	
	public Object dequeue() {
		_marker--;
		return _queue.dequeue();
	}
	
	public int maximumSize() {
		return _marker;
	}

	@Override
	public Object peek() {
		return _queue.peek();
	}

	@Override
	public boolean isEmpty() {
		return _queue.isEmpty();
	}
	
}