package com.bbd.test.data;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.apache.deltaspike.testcontrol.api.junit.CdiTestRunner;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.bbd.data.StudentDAO;
import com.bbd.data.entities.Student;

@RunWith(CdiTestRunner.class)
public class StudentDAOTest {

	@Inject
	StudentDAO dao;

	Student test1, test2;

	@Before
	public void setUp() throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date dRor = sdf.parse("15/08/1979");
		Date dEin = sdf.parse("14/03/1879");

		test1 = new Student("Rory", "Preddy", dRor, true);
		test2 = new Student("Albert", "Einstein", dEin, false);
	}

	/**
	 * Test of getAllStudents method, of class StudentDAO.
	 */
	@Test
	public void testGetAllStudents() {
		List<Student> Students = dao.getAllStudents();
		assertNotNull("The returned value MUST NOT be null.", Students);
		// assertTrue("The returned list MUST be of length 0",
		// Students.isEmpty());
	}

	/**
	 * Test of getStudent method, of class StudentDAO.
	 */
	@Test
	public void testGetStudent() {
		Student persisted1 = dao.addStudent(test1);
		Student item = dao.getStudent(persisted1.getId());
		assertNotNull("The returned Student item MUST NOT be null", item);
		assertTrue(
				"The returned Student item MUST have an ID of "
						+ persisted1.getId(),
				item.getId() == persisted1.getId());
	}

	/**
	 * Test of addStudent method, of class StudentDAO.
	 */
	@Test
	public void testAddStudent() {
		Student persisted1 = dao.addStudent(test1);
		assertNotNull("The returned entity MUST NOT be null", persisted1);
		assertNotNull(
				"Once persisted to the database, the ID MUST NOT be null.",
				persisted1);
		Student persisted2 = dao.addStudent(test2);
		assertNotNull("The returned entity MUST NOT be null", persisted2);
		assertNotNull(
				"Once persisted to the database, the ID MUST NOT be null.",
				persisted2);
		assertNotEquals("The IDs of the entities MUST NOT be the same.",
				persisted1, persisted2);
	}

	/**
	 * Test of updateStudent method, of class StudentDAO.
	 */
	@Test
	public void testUpdateStudent() {
		Student added = dao.addStudent(test1);
		Student persisted1 = dao.getStudent(added.getId());
		Date origBirthDate = persisted1.getBirthDate();
		Student item = new Student();
		item.setId(persisted1.getId());
		item.setEnrolled(persisted1.getEnrolled());
		item.setLastName(persisted1.getLastName());
		item.setBirthDate(new Date());
		Student updated = dao.updateStudent(item);
		assertNotNull("The returned entity MUST NOT be null", updated);
		assertNotEquals(
				"The updated entity MUST NOT have the same birth date and the original.",
				origBirthDate, updated.getBirthDate());
	}

	/**
	 * Test of deleteStudent method, of class StudentDAO.
	 */
	@Test
	public void testDeleteStudent() {
		Student persisted1 = dao.addStudent(test1);
		boolean retVal = dao.deleteStudent(persisted1.getId());
		assertTrue(
				"Delete operation MUST return true for object which exists in DB.",
				retVal);
	}

}
