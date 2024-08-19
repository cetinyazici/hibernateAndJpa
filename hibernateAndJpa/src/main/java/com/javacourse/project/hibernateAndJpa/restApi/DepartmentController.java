package com.javacourse.project.hibernateAndJpa.restApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javacourse.project.hibernateAndJpa.Business.IDepartmentService;
import com.javacourse.project.hibernateAndJpa.Entities.Department;

@Controller
@RequestMapping("/departments")
public class DepartmentController {
	private IDepartmentService departmentService;

	@Autowired
	public DepartmentController(IDepartmentService departmentService) {
		this.departmentService = departmentService;
	}

	@GetMapping("/list")
	public String listDepartments(Model model) {
		model.addAttribute("departments", departmentService.getAll());
		return "departments/list";
	}

	@GetMapping("/add")
	public String showAddForm(Model model) {
		model.addAttribute("department", new Department());
		return "departments/add";
	}

	@PostMapping("/add")
	public String addDepartment(Department department) {
		departmentService.add(department);
		return "redirect:/departments/list";
	}

	@GetMapping("/edit/{id}")
	public String showEditForm(@PathVariable int id, Model model) {
		Department department = departmentService.getById(id);
		model.addAttribute("department", department);
		return "departments/edit";
	}

	@PostMapping("/edit/{id}")
	public String updateDepartment(@PathVariable int id, Department department) {
		department.setId(id);
		departmentService.update(department);
		return "redirect:/departments/list";
	}

	@GetMapping("/detail/{id}")
	public String showDetail(@PathVariable int id, Model model) {
		Department department = departmentService.getById(id);
		if (department != null) {
			model.addAttribute("department", department);
			return "departments/detail";
		} else {
			return "error/404";
		}
	}

	@PostMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable int id) {
		Department department = departmentService.getById(id);
		if (department != null) {
			departmentService.delete(department);
		}
		return "redirect:/departments/list";
	}

}
