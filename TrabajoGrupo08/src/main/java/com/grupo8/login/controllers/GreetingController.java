package com.grupo8.login.controllers;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.grupo8.login.models.dtos.EmployeeAddDTO;
import com.grupo8.login.models.dtos.EmployeeLoginDTO;
import com.grupo8.login.models.dtos.EmployeeResponseDTO;
import com.grupo8.login.models.dtos.EmployeeSearchDTO;
import com.grupo8.login.services.EmployeeService;
import com.grupo8.login.services.EmployeeServiceImplementation;
import com.grupo8.login.services.utils.ServiceResponse;
import com.grupo8.models.entities.Employee;

@Controller
@RequestMapping("/employee")

public class GreetingController {
	
	@Autowired
	private EmployeeService employeeService;
	
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	public String getMainPage(Model model) {		
		String time = Calendar.getInstance().getTime().toString();
		model.addAttribute("time", time); 
		model.addAttribute("search", new EmployeeLoginDTO("", ""));
		return "login";		
	}
	
	@GetMapping("/greeting")
	public String getUserPage(Model model ) {
		return "redirect:/employee/";
	}

	@PostMapping("/greeting")
	private String requestUser(@ModelAttribute(name="search") @Valid EmployeeLoginDTO search, 
			BindingResult result, Model model) {
			
		String time = Calendar.getInstance().getTime().toString();
		model.addAttribute("time", time); 				
		String usuario = search.getUsuario();
		String contrasena = search.getContrasena();
		
		ServiceResponse<Employee> foundEmployees = employeeService.getOneById(usuario);
		
		Employee foundUser = foundEmployees.getData();
		
		if(foundUser == null || !foundUser.getContrasena().equals(contrasena)) {
			return "error";
		}
			
		EmployeeResponseDTO response = new EmployeeResponseDTO(
				foundUser.getUsuario(),
				foundUser.getNombre(),
				foundUser.getApellido(),
				foundUser.getContratacion(),
				foundUser.getRol()
				);
		
		model.addAttribute("employee" , response);
						
		ServiceResponse<List<Employee>> employeesMapped = employeeService.getAll();
		
		
		model.addAttribute("users", employeesMapped.getData());
			
		
		if(foundUser.getRol() == "admin" && foundUser.getActivo() == "activo") {
			return "greeting";
		}
		else if (foundUser.getActivo() == "activo") {
			return "greetingUser";
		}
		else {			
			return "error";		
		}			
	}
	

	@GetMapping("/add")
	public String getAddPage(Model model) {
		model.addAttribute("addemployee", new EmployeeAddDTO("", "", "", "", ""));
		return "addEmployee";
	}
	
	@PostMapping("/add")
	public String addEmployee(
			@ModelAttribute(name="addemployee") @Valid EmployeeAddDTO employeeInfo,
			BindingResult result,
			Model model
			) {
		if(result.hasErrors()) {
			model.addAttribute("error", "Error de registro");
			return "addEmployee";
		}
		
		ServiceResponse<Employee> foundEmployee = 
				employeeService.getOneById(employeeInfo.getUsuario());
		
		if(foundEmployee.getData() != null) {
			model.addAttribute("error", "Este Empleado ya existe");
			return "redirect:/employee/";
		}
		
		ServiceResponse<Void> insertResponse 
			= employeeService.insert(new Employee(
					employeeInfo.getUsuario(),
					employeeInfo.getNombre(),
					employeeInfo.getApellido(),
					employeeInfo.getContratacion(),
					employeeInfo.getContrasena()
					));
		
		return "redirect:/employee/";
	}

	
	@PostMapping("/greeting/fail/{usuario}")
	private String getFailCounter(@PathVariable("usuario") String nombre, Model model) {
		
		ServiceResponse<Employee> foundEmployee = employeeService.getOneById(nombre);
		Employee employee = foundEmployee.getData();
		employeeService.counterFaultsEmployee(employee.getUsuario());
		
		return "redirect:/employee/greeting";
	}
	
	@PostMapping("/greeting/bonus/{usuario}")
	private String getBonusCounter(@PathVariable("usuario") String nombre, Model model) {
		
		ServiceResponse<Employee> foundEmployee = employeeService.getOneById(nombre);
		Employee employee = foundEmployee.getData();
		employeeService.counterBonusEmployee(employee.getUsuario());
		
		return "redirect:/employee/greeting";
	}
	
	
	@PostMapping("/greeting/rol/{usuario}")
	private String modifyRol(@PathVariable("usuario") String nombre, Model model) {
		ServiceResponse<Employee> foundEmployee = employeeService.getOneById(nombre);
		Employee employee = foundEmployee.getData();
		employeeService.upgradeEmployee(employee.getUsuario());
		
		return "redirect:/employee/greeting";
	}
	
	@PostMapping("/greeting/status/{usuario}")
	private String modifyStatus(@PathVariable("usuario") String nombre, Model model) {
		ServiceResponse<Employee> foundEmployee = employeeService.getOneById(nombre);
		Employee employee = foundEmployee.getData();
		employeeService.activateEmployee(employee.getUsuario());
		
		return "redirect:/employee/greeting";
	}
	
}
