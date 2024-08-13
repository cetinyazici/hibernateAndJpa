package com.javacourse.project.hibernateAndJpa.Business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.javacourse.project.hibernateAndJpa.DataAccess.IDepartmentDal;
import com.javacourse.project.hibernateAndJpa.Entities.Department;
import jakarta.transaction.Transactional;

@Service
public class DepartmentManager implements IDepartmentService {

	private IDepartmentDal departmentDal;

	@Autowired
	public DepartmentManager(IDepartmentDal dal) {
		this.departmentDal = dal;
	}

	@Override
	@Transactional
	public List<Department> getAll() {
		return departmentDal.getAll();
	}

	@Override
	@Transactional
	public void add(Department department) {
		departmentDal.add(department);
	}

	@Override
	@Transactional
	public void update(Department department) {
		departmentDal.update(department);

	}

	@Override
	@Transactional
	public void delete(Department department) {
		departmentDal.delete(department);

	}

	@Override
	public Department getById(int id) {
		return departmentDal.getById(id);
	}

}
