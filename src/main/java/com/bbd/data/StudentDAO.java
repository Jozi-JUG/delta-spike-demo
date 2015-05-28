package com.bbd.data;

import com.bbd.data.entities.Student;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.apache.deltaspike.jpa.api.transaction.Transactional;

@SessionScoped
public class StudentDAO implements Serializable {

	@Inject
	private EntityManager em;

	public StudentDAO() {
	}

	@Transactional
	public List<Student> getAllStudents() {
		try {
			return em.createQuery("FROM Student").getResultList();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public Student getStudent(Long id) {
		try {
			return em.find(Student.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public Student addStudent(Student item) {
		try {
			Student retVal = em.merge(item);
			em.flush();
			return retVal;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public Student updateStudent(Student item) {
		try {
			Student retVal = em.merge(item);
			em.flush();
			return retVal;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	@Transactional
	public boolean deleteStudent(Long id) {
		try {
			em.remove(em.find(Student.class, id));
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}
}
