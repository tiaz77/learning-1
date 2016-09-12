package ch.gmtech.learning.seminar;

import static java.util.Arrays.*;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.apache.commons.io.IOUtils;
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
	public void rendersInCsv() {
		List<Student> students = asList(new Student("Tizio", "Cognome"), new Student("Tizio2", "Cognome2"));
		Course lambdaCalculus = new Course("Lambda calculus", "1", "Lugano", 10, students);

		String content = lambdaCalculus.renderCsv();
		
		assertThat(content, containsString("\"Lambda calculus\";"));
		assertThat(content, containsString("\"Tizio\";"));
		assertThat(content, containsString("\"Tizio2\";\"Cognome2\""));
	}
	
	@Test
	public void rawRender() {
		String newLine = IOUtils.LINE_SEPARATOR;
		
		List<Student> students = asList(new Student("Tizio", "Cognome"), new Student("Tizio2", "Cognome2"));
		Course lambdaCalculus = new Course("Lambda calculus", "1", "Lugano", 10, students);
		
		String content = lambdaCalculus.render();
		
		assertThat(content, is("Lambda calculus 1 Lambda calculus 1" + newLine
				+ "location: Lugano" + newLine
				+ "seats left: 8"
				+ newLine
				+ newLine
				+ "Enrollment:" + newLine
				+ "Tizio Cognome" + newLine
				+ "Tizio2 Cognome2"));
	}
}