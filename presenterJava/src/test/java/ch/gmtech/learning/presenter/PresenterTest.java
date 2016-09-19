package ch.gmtech.learning.presenter;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;


public class PresenterTest {

	@Test
	public void chooseAPresenterInCandidates() {
        List<String> presenters = asList("a", "b");
        
        String presenter = new Presenter(presenters, new ArrayList<String>()).next();

        assertThat(presenter, isIn(presenters));
    }
	
	@Test
	public void emptyCandidatesReturnNoPresenter() {
		List<String> presenters = asList();
		
		String presenter = new Presenter(presenters, new ArrayList<String>()).next();
		
		assertThat(presenter, is(""));
	}
	
	@Test
	public void excludePresenter() {
		List<String> presenters = asList("b");
		List<String> excluding = asList("b");
		
		String presenter = new Presenter(presenters, excluding).next();
		
		assertThat(presenter, is(""));
	}
	
}
