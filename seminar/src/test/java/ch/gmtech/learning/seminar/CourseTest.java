package ch.gmtech.learning.seminar;

import static java.util.Arrays.*;
import static org.apache.commons.io.FileUtils.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

import org.junit.Test;

import ch.gmtech.learning.seminar.view.Html;


public class CourseTest {

	@Test
	public void rendersInHtml() {
		List<Student> students = asList(new Student("Tizio", "Cognome"), new Student("Tizio2", "Cognome2"));
		Course lambdaCalculus = new Course("Lambda calculus", "1", "Lugano", 10, students);
		
		Html expectedHtml = new Html().html(
				new Html().head(
						new Html().title("Lambda calculus")),
				new Html().body(
						new Html().div("Nome Corso:"),
						new Html().ul(
								new Html().li("Lambda calculus 1"), 
								new Html().li("Lugano"), 
								new Html().li("8")),
						new Html().div("Partecipanti:"),
						new Html().ul(new Html().li("Tizio Cognome"), new Html().li("Tizio2 Cognome2"))));
		
		assertThat(lambdaCalculus.renderHtml(), is(expectedHtml.render()));
	}
	
	@Test
	public void rendersInCsv() throws Exception {
		List<Student> students = asList(new Student("Tizio", "Cognome"), new Student("Tizio2", "Cognome2"));
		Course lambdaCalculus = new Course("Lambda calculus", "1", "Lugano", 10, students);

		File file = new File(getTempDirectory(), "Lambda calculus.csv");
		lambdaCalculus.renderCsv(file);
		
		String fileContent = readFileToString(file, StandardCharsets.UTF_8.name());
		
		assertThat(fileContent, containsString("Lambda calculus"));
		assertThat(fileContent, containsString("Tizio"));
		assertThat(fileContent, containsString("Tizio2"));
	}
}