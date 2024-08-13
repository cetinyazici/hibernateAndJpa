package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import com.javacourse.project.hibernateAndJpa.Entities.Department;

public interface IDepartmentService {

	List<Department> getAll();

	Department getById(int id);

	void add(Department department);

	void update(Department department);

	void delete(Department department);
}
