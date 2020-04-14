package com.myorg.ems.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.myorg.ems.model.Employee;
import com.myorg.ems.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService service;


	//method to show home page
	@RequestMapping("/")
	public String showHomePage() {
		System.out.println("Entering showHomePage()");
		return "home";
	}

	// This method is to navigate you to the home page from the navigation bar
	@RequestMapping("/home")
	public String viewHomePage(Model model) {
		System.out.println("Entering viewHomePage()");
		return "home";
	}

	// This method is to list all the employee
	@RequestMapping("/listEmployee")
	public String viewEmployeeList(Model model) {
		List<Employee> listEmployee = service.listAll();
		model.addAttribute("listEmployee", listEmployee);
		return "employeeList";
	}


	//
	@RequestMapping("/add")
	public String showNewEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";//newUser
	}

	/*@RequestMapping(value = "/saveEmployee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		service.save(employee);
		return "redirect:/";
	}*/


	// binding the data from the view to the model
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public String saveEmployee(@Valid Employee employee, BindingResult bindingResult, Model model) {
		System.out.println("Entering saveEmployee()");
		System.out.println("bindingResult : " + bindingResult);
		System.out.println("bindingResult : " + bindingResult.hasErrors());
		if(bindingResult.hasErrors()) {
			System.out.println("Binding result has errors");
			return "addEmployee";
		}
		System.out.println("Call save()... ");
		service.save(employee);
		return "redirect:/listEmployee";

	}

	// method to edit employee
	@RequestMapping("/edit/{id}")
	public ModelAndView showEditEmployeeForm(@PathVariable(name = "id") int id) {
		ModelAndView mav = new ModelAndView("editEmployee");
		Employee employee = service.get(id);
		mav.addObject("employee", employee);
		return mav;
	}

	// method to delete employee 
	@RequestMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable(name = "id") int id) {
		service.delete(id);
		return "redirect:/listEmployee";
	}

	// method to show logout page
	@RequestMapping("/logout")
	public String viewLogoutPage(Model model) {
		System.out.println("Entering viewLogoutPage()");
		return "logout";
	}


}

