package ch.gmtech.learning.seminar.view;

import static java.util.Arrays.*;
import static org.apache.commons.io.FileUtils.*;
import static org.apache.commons.lang3.StringUtils.*;
import static org.junit.Assert.*;

import java.io.File;
import java.util.List;

import org.hamcrest.core.Is;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

@SuppressWarnings("unchecked")
public class CsvRenderTest {

	private File _file;
	
	@Before
	public void init() {
		_file = new File(getTempDirectory(), "test.csv");
	}
	
	@After
	public void clean() {
		deleteQuietly(_file);
	}

	@Test
	public void writeLines() throws Exception {
		CsvRender builder = new CsvRender(_file);
		
		List<String> firstLine = asList("a", "b", "c");
		List<String> secondLine = asList("a1", "b1");
		builder.render(asList(firstLine,secondLine));
		
		assertThat(readLines(_file, "UTF-8"), Is.is(asList(
				join(asList("\"a\"", "\"b\"", "\"c\""), ";"),
				join(asList("\"a1\"", "\"b1\""), ";"))
		));
	}
	
}