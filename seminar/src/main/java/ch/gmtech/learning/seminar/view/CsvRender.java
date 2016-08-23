package ch.gmtech.learning.seminar.view;

import static java.util.Arrays.*;
import static org.apache.commons.collections4.CollectionUtils.*;
import static org.apache.commons.io.FileUtils.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.Transformer;

public class CsvRender {

	private File _file;

	public CsvRender(File file) {
		_file = file;
	}

	public void render(List<List<String>> data) {
		
		try {
			for (List<String> line : data) {
				
				Collection<String> values = collect(line, new Transformer<String, String>() {
					public String transform(String input) {
						return "\""+input+"\"";
					}
				});
				
				writeLines(_file, StandardCharsets.UTF_8.name(), asList(join(values, ";")), true);
				
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

}