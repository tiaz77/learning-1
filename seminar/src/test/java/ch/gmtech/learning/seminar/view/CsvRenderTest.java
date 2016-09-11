package ch.gmtech.learning.seminar.view;

import static java.util.Arrays.asList;
import static org.apache.commons.lang3.StringUtils.join;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hamcrest.core.Is;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class CsvRenderTest {

	@Test
	public void writeLines() throws Exception {
		CsvRender csv = new CsvRender();
		
		List<String> firstLine = asList("a", "b", "c");
		List<String> secondLine = asList("a1", "b1");
		
		String expected = join(asList("\"a\"", "\"b\"", "\"c\""), ";")
				+ IOUtils.LINE_SEPARATOR 
				+ join(asList("\"a1\"", "\"b1\""), ";");
		
		assertThat(csv.render(asList(firstLine,secondLine)), Is.is(expected));
	}
	
}