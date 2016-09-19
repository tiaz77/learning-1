package ch.gmtech.learning.presenter;

import static java.util.Arrays.*;
import static org.apache.commons.io.FileUtils.*;
import static org.apache.commons.lang3.time.DateFormatUtils.*;

import java.io.File;
import java.util.Date;
import java.util.List;

public class Application {
	
	private static final String CANDIDATES_FILENAME = "presenters.txt";
	private static final String LOG_FILENAME = "excluded.log";

	public void execute(String[] args) throws Exception {
		
		File file = new File(CANDIDATES_FILENAME);
		
		List<String> presenters = readLines(file, "UTF-8");
		List<String> excluding = asList(args);
		
		String presenter = new Presenter(presenters, excluding).next();
		
		String logFileName = format(new Date(), "yyyyMMdd") + "-" + LOG_FILENAME;
		
		writeLines(new File(logFileName), "UTF-8", excluding);
		
		System.out.println(presenter);
		
	}

}