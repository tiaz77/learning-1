package ch.gmtech.learning.seminar.view;

import static org.junit.Assert.*;

import org.hamcrest.core.Is;
import org.junit.Test;

public class HtmlTest {

	@Test
	public void buildsNestedTags() {
		Html builder = new Html().
				html(new Html().head(new Html().title("ciao")),
					 new Html().div("bye")
		);
		
		assertThat(builder.render(), Is.is("<html><head><title>ciao</title></head><div>bye</div></html>"));
	}
	
	@Test
	public void simpleTag() {
		Html builder = new Html().title("ciao");
		
		assertThat(builder.render(), Is.is("<title>ciao</title>"));
	}
	
}