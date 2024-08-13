package com.javacourse.project.hibernateAndJpa.DataAccess;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.javacourse.project.hibernateAndJpa.Entities.Department;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

//JPA (Java Persistence API)
@Repository
public class HibernateDepartmentDal implements IDepartmentDal {

	private EntityManager entityManager;

	@Autowired
	public HibernateDepartmentDal(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	// AOP -> Aspect Oriented Programming
	@Override
	@Transactional
	public List<Department> getAll() {
		Session session = entityManager.unwrap(Session.class);
		List<Department> departments = session.createQuery("from Department", Department.class).getResultList();
		return departments;
	}

	@Override
	public void add(Department department) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(department);

	}

	@Override
	public void update(Department department) {
		Session session = entityManager.unwrap(Session.class);
		session.merge(department);
	}

	@Override
	public void delete(Department department) {
		Session session = entityManager.unwrap(Session.class);
		Department departmentToDelete = session.get(Department.class, department.getId());
		session.remove(departmentToDelete);

	}

	@Override
	public Department getById(int id) {
		Session session = entityManager.unwrap(Session.class);
		Department department = session.get(Department.class, id);
		return department;
	}

}
