package com.atfc.project.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.atfc.project.management.dao.IEmployeeRepository;
import com.atfc.project.management.dao.IProjectRepository;
import com.atfc.project.management.entities.Employee;
import com.atfc.project.management.entities.Project;

@Controller
public class HomeController {
	
	@Autowired
	IProjectRepository proRepo;
	
	@Autowired
	IEmployeeRepository empRepo;
	
    @GetMapping("/") 
	public String displayHome(Model model) {
    	
    	List<Project> projects = proRepo.findAll();
		 model.addAttribute("projects",projects);
		 
		 List<Employee> employees = empRepo.findAll();
		 model.addAttribute("employeesList",employees);
		 
		 
		 return "home";
	} 
	
}
