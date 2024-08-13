package com.javacourse.project.hibernateAndJpa.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department")
public class Department {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "location")
	private String location;

	@Column(name = "head_of_department")
	private String head_of_department;

	public Department() {
	}

	public Department(int id, String name, String location, String head_of_department) {
		super();
		this.id = id;
		this.name = name;
		this.location = location;
		this.head_of_department = head_of_department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getHead_of_department() {
		return head_of_department;
	}

	public void setHead_of_department(String head_of_department) {
		this.head_of_department = head_of_department;
	}
}
