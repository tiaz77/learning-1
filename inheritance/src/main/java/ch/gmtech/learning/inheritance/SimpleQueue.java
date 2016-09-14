package ch.gmtech.learning.inheritance;

import java.util.ArrayList;
import java.util.List;

public class SimpleQueue implements Queue {

	private List<Object> _elements;
	
	public SimpleQueue() {
		_elements = new ArrayList<Object>();
	}
	
	@Override
	public void enqueue(Object o) {
		_elements.add(o);
	}
	
	@Override
	public Object dequeue() {
		return _elements.isEmpty() ? null : _elements.remove(0);
	}

	@Override
	public Object peek() {
		return _elements.isEmpty() ? null : _elements.get(0);
	}

	@Override
	public boolean isEmpty() {
		return _elements.isEmpty();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_elements == null) ? 0 : _elements.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SimpleQueue other = (SimpleQueue) obj;
		if (_elements == null) {
			if (other._elements != null)
				return false;
		} else if (!_elements.equals(other._elements))
			return false;
		return true;
	}
	
}