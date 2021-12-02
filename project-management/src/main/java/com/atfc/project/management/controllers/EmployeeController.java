package com.atfc.project.management.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atfc.project.management.dao.IEmployeeRepository;
import com.atfc.project.management.entities.Employee;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	@Autowired
	IEmployeeRepository empRepo;
	
	
	@GetMapping("/new")
	public String displayEmployeeForm(Model model) {
		    
		Employee anEmployee = new Employee();
		
		model.addAttribute("employee",anEmployee);
		
		return "new-employee";
	}
	
	
	@PostMapping("/save")
	public String createEmployee(Model model,Employee employee) {
		// save to db using employee crud repo
		
		empRepo.save(employee);
		
		return "redirect:/employees/new"; 
	}
	

}
