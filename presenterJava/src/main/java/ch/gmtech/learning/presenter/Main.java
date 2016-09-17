package ch.gmtech.learning.presenter;

import static org.apache.commons.io.FileUtils.readLines;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class Main {
    
	public static void main( String[] args ) throws Exception {
		
		List<String> presenters = readLines(new File(args[0]), StandardCharsets.UTF_8);
		
		String presenter = new Presenter(presenters).next();
		
		System.out.println(presenter);
		
    }
	
}