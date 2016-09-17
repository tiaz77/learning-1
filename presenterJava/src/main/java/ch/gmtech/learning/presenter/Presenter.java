package ch.gmtech.learning.presenter;

import java.util.List;
import java.util.Random;

public class Presenter {

	private final List<String> _candidates;

	public Presenter(List<String> candidates) {
		_candidates = candidates;
	}

	public String next() {
		
		Random generator = new Random();
		
		int index = generator.nextInt(_candidates.size());
		
		return _candidates.get(index);
		
	}

}
