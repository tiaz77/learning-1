package ch.gmtech.learning.presenter;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.isIn;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;


public class PresenterTest {

	@Test
	public void chooseAPresenterInCandidates() {
        List<String> presenters = asList("a", "b");
        
        String presenter = new Presenter(presenters).next();

        assertThat(presenter, isIn(presenters));
    }
	
}
