package com.atfc.project.management.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.atfc.project.management.dao.IEmployeeRepository;
import com.atfc.project.management.dao.IProjectRepository;
import com.atfc.project.management.entities.Employee;
import com.atfc.project.management.entities.Project;

@Controller
@RequestMapping("/projects")
public class ProjectController {
	
	@Autowired
	IProjectRepository proRepo;
	 
	@Autowired
	IEmployeeRepository empRepo;
	
	@GetMapping
	public String displayProjects(Model model) {
		 List<Project> projects = proRepo.findAll();
		 model.addAttribute("projects",projects);
		 return "projects/list-projects";
		
	}
	
	
	@GetMapping("/new")
	public String displayProjectForm(Model model) {
		
		Project aProject = new Project();
		
		List<Employee> employees = empRepo.findAll();
		model.addAttribute("allEmployees",employees);
		model.addAttribute("project",aProject);
		
		return "projects/new-project";
	}
	
	@PostMapping("/save")
	public String createProject(Project project, @RequestParam List<Long> employees, Model model) {
		//saving to db
		proRepo.save(project);
		
		
		 Iterable<Employee> chosenEmployees = empRepo.findAllById(employees);
		 
		 for(Employee emp : chosenEmployees) {
			 emp.setTheProject(project);
			 empRepo.save(emp);
		 }
		
		
		//redirect to prevent multiple submissions
		return "redirect:/projects/new";
	}
}
