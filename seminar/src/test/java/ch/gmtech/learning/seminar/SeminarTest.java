package ch.gmtech.learning.seminar;

import static java.util.Arrays.*;
import static org.junit.Assert.*;

import java.util.List;

import org.hamcrest.core.Is;
import org.hamcrest.core.IsCollectionContaining;
import org.junit.Test;


public class SeminarTest {

	@Test
	public void showsStudents() {
		Course lambdaCalculus = new Course("Lambda calculus", "1");
		List<Enrollment> students = asList(new Enrollment(new Student("Tizio", "Cognome")));

		Seminar seminar = new Seminar(lambdaCalculus, students, "Lugano", 10);
		
		assertThat(seminar.getStudentList(), IsCollectionContaining.hasItems("Tizio Cognome"));
		assertThat(seminar.getSeatsLeft(), Is.is(9));
	}

}