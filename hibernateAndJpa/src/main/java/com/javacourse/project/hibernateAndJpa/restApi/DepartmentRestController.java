
package com.javacourse.project.hibernateAndJpa.restApi;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javacourse.project.hibernateAndJpa.Business.IDepartmentService;
import com.javacourse.project.hibernateAndJpa.Entities.Department;

import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {

	private IDepartmentService departmentService;

	@Autowired
	public DepartmentRestController(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/departments")
	public List<Department> get() {
		return departmentService.getAll();
	}
	
	@GetMapping("/departments/{id}")
	public Department getById(@PathVariable int id) {
		return departmentService.getById(id);
	}

	@PostMapping("/add")
	public void add(@RequestBody Department department) {
		departmentService.add(department);
	}

	@PutMapping("/{id}")
    public void update(@PathVariable int id, @RequestBody Department department) {
        department.setId(id);
        departmentService.update(department);
    }

	@DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        Department department = departmentService.getById(id);
        departmentService.delete(department);
    }

}
