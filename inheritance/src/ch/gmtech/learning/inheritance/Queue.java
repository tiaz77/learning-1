package ch.gmtech.learning.inheritance;

import java.util.ArrayList;
import java.util.List;

public class Queue {

	private List<Object> _elements;
	
	public Queue() {
		_elements = new ArrayList<Object>();
	}
	
	public void enqueue(Object o) {
		_elements.add(o);
	}
	
	public Object dequeue() {
		return _elements.get(0);
	}
	
}