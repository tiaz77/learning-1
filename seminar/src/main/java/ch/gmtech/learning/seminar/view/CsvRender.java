package ch.gmtech.learning.seminar.view;

import static org.apache.commons.collections4.CollectionUtils.collect;
import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.removeEnd;

import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.Transformer;
import org.apache.commons.io.IOUtils;

public class CsvRender {

	public String render(List<List<String>> data) {

		String result = "";

		for (List<String> line : data) {

			Collection<String> values = collect(line, new Transformer<String, String>() {
				
						public String transform(String input) {
							return "\"" + input + "\"";
						}
						
					});

			result += join(values, ";") + IOUtils.LINE_SEPARATOR;

		}

		return removeEnd(result, IOUtils.LINE_SEPARATOR);

	}

}