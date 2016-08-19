package ch.gmtech.learning.seminar;

import static java.util.Arrays.*;
import static org.hamcrest.core.Is.*;
import static org.hamcrest.core.IsCollectionContaining.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


public class CourseTest {

	@Test
	public void showsStudents() {
		List<Student> students = asList(new Student("Tizio", "Cognome"));
		Course lambdaCalculus = new Course("Lambda calculus", "1", "Lugano", 10, students);

		assertThat(lambdaCalculus.getStudentList(), hasItems("Tizio Cognome"));
		assertThat(lambdaCalculus.getSeatsLeft(), is(9));
	}
	
	@Test
	public void rendersInHtml() {
		List<Student> students = asList(new Student("Tizio", "Cognome"), new Student("Tizio2", "Cognome2"));
		Course lambdaCalculus = new Course("Lambda calculus", "1", "Lugano", 10, students);
		
		assertThat(lambdaCalculus.render(), is("<html>"
				+ "<head><title>Lambda calculus</title></head>"
				+ "<body><div>Nome Corso:</div><ul><li>Lambda calculus 1</li><li>Lugano</li><li>8</li></ul>"
				+ "<div>Partecipanti:</div><ul><li>Tizio Cognome</li><li>Tizio2 Cognome2</li></ul></body></html>"));
	}

}