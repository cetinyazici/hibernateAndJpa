package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;
import com.javacourse.project.hibernateAndJpa.Entities.Department;

public interface IDepartmentDal {

	List<Department> getAll();
	
	Department getById(int id);

	void add(Department department);

	void update(Department department);

	void delete(Department department);

}
