package com.bbd.data.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "student")
@XmlRootElement(name = "student")
public class Student implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@XmlAttribute(required = true)
	private Long id;

	@XmlElement(required = true)
	private String name;

	@XmlElement(nillable = true)
	private String lastName;

	@XmlElement(required = false)
	private Date birthDate;

	@XmlAttribute(required = true)
	private Boolean enrolled = Boolean.FALSE;

	
	public Student() {
	}
	
	public Student(String name, String lastName, Date birthDate,
			Boolean enrolled) {
		this();
		this.name = name;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.enrolled = enrolled;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String Name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public Boolean getEnrolled() {
		return enrolled;
	}

	public void setEnrolled(Boolean enrolled) {
		this.enrolled = enrolled;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", lastName="
				+ lastName + ", birthDate=" + birthDate + ", enrolled="
				+ enrolled + "]";
	}

	
	
}
