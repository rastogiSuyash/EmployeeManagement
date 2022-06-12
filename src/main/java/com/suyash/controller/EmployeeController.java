package com.suyash.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.suyash.model.Employee;
import com.suyash.service.EmployeeService;

@Controller
public class EmployeeController {
	//display list of employees
	
	@Autowired
	private EmployeeService employeeService;
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "index";
	}
	@GetMapping("/showNewEmployeeForm")
	public String showNewEmployeeForm(Model model) {
		Employee emp=new Employee();
		model.addAttribute("employee", emp);
		return "new_employee";
	}
	
	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		
		employeeService.saveEmployee(employee);
		return "redirect:/";
		
	}
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable (value="id") long id, Model model) {
		//get employee from the dservice
		
		Employee emmp=employeeService.getEmployeeById(id);
		
		//set employee as a model to pre-populate
		model.addAttribute("employee", emmp);
		return "update_employee";
	}
	
	@GetMapping("/deleteEmployee/{id}")
	public String deleteEmp(@PathVariable (value= "id") long id) {
		this.employeeService.deleteEmployee(id);
		return "redirect:/";
	}

}
