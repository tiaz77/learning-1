package ch.gmtech.learning.inheritance;


public class MonitorableQueue implements Queue {

	private final Queue _queue;
	
	private int _maxSize;
	private int _currentSize;
	
	public MonitorableQueue() {
		_queue = new SimpleQueue();
		_maxSize = 0;
		_currentSize = 0;
	}
	
	@Override
	public void enqueue(Object o) {
		_queue.enqueue(o);
		_currentSize++;
		if (_currentSize > _maxSize) {
			_maxSize = _currentSize;
		}
	}
	
	@Override
	public Object dequeue() {
		_currentSize--;
		return _queue.dequeue();
	}

	public int maximumSize() {
		return _maxSize;
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