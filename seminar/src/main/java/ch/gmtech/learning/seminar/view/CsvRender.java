package ch.gmtech.learning.seminar.view;

import static org.apache.commons.collections4.CollectionUtils.*;
import static org.apache.commons.lang3.StringUtils.*;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.io.IOUtils;

public class CsvRender extends AbstractView {

	private final List<List<String>> _data;
	private final String _fieldSeparator;
	private final String _textDelimiter;

	public CsvRender(List<List<String>> data) {
		this(data, ";", "\"");
	}
	
	public CsvRender(List<List<String>> data, String separator, String delimiter) {
		_data = data;
		_fieldSeparator = separator;
		_textDelimiter = delimiter;
	}

	String renderImpl() {

		String result = "";

		for (List<String> line : _data) {

			Collection<String> values = collect(line, new Transformer<String, String>() {
				
						public String transform(String input) {
							return _textDelimiter + input + _textDelimiter;
						}
						
					});

			result += join(values, _fieldSeparator) + IOUtils.LINE_SEPARATOR;

		}

		return removeEnd(result, IOUtils.LINE_SEPARATOR);

	}

}