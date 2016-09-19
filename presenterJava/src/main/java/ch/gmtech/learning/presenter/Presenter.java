package ch.gmtech.learning.presenter;

import static org.apache.commons.collections4.ListUtils.*;

import java.util.List;
import java.util.Random;

public class Presenter {

	private final List<String> _presenters;
	private final List<String> _excluding;

	public Presenter(List<String> presenters, List<String> excluding) {
		_presenters = presenters;
		_excluding = excluding;
	}

	public String next() {
		List<String> candidates = subtract(_presenters, _excluding);
		
		if (!candidates.isEmpty()) {
			
			Random generator = new Random();
			int index = generator.nextInt(candidates.size());
			return candidates.get(index);
			
		}
		
		return "";
		
	}

}