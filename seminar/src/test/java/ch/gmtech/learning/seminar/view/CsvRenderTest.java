package ch.gmtech.learning.seminar.view;

import static java.util.Arrays.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.io.IOUtils;
import org.hamcrest.core.Is;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class CsvRenderTest {

	@Test
	public void writeLines() {
		List<String> firstLine = asList("a", "b", "c");
		List<String> secondLine = asList("a1", "b1");
		
		String expected = join(asList("\"a\"", "\"b\"", "\"c\""), ";")
				+ IOUtils.LINE_SEPARATOR 
				+ join(asList("\"a1\"", "\"b1\""), ";");
		
		assertThat(new CsvRender(asList(firstLine,secondLine)).render(), Is.is(expected));
}
	
}