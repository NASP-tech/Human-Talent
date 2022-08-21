package com.grupo8.login.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.grupo8.login.services.utils.ServiceResponse;
import com.grupo8.models.entities.Employee;

@Service
public class EmployeeServiceImplementation implements EmployeeService{
	
	private static Map<String, Employee> employees = new HashMap<>();

	static {
		Employee employee1 = new Employee("FH782349", "Natalia", "Solórzano", "18-octubre-2007", "activo", "admin", "contrasena");
        Employee employee2 = new Employee("IT273482", "Ilda", "Torres", "24-abril-2013", "activo", "usuario", "MiContrasena1234.");
        Employee employee3 = new Employee("OS517323", "Olga", "Salvador", "16-junio-2020", "inactivo", "admin", "UsandoContrasena12.");
        Employee employee4 = new Employee("PE913872", "Pedro", "Escobar", "30-enero-2015", "activo", "admin", "VerdaderaContrasena5.");
        Employee employee5 = new Employee("UI432871", "Uzziel", "Ibarra", "24-noviembre-2019", "inactivo", "usuario", "Estasieslacontrasena7.");
        Employee employee6 = new Employee("TV034723", "Travis", "Villarubio", "9-febrero-2016", "activo", "usuario", "Noolvidarcontrasena258.");
        Employee employee7 = new Employee("NW892532", "Nathan", "White", "10-diciembre-2021", "activo", "usuario", "Contrasenaefectiva784.");

		employees.put(employee1.getUsuario(), employee1);
		employees.put(employee2.getUsuario(), employee2);
		employees.put(employee3.getUsuario(), employee3);
		employees.put(employee4.getUsuario(), employee4);
		employees.put(employee5.getUsuario(), employee5);
		employees.put(employee6.getUsuario(), employee6);
		employees.put(employee7.getUsuario(), employee7);
	}
	
	@Override
	public ServiceResponse<Void> insert(Employee employee) {
		try {
			employees.put(employee.getUsuario(), employee);
			return new ServiceResponse<>(true);
		}catch(Exception e) {
			return new ServiceResponse<>(false);
		}
		
	}

	@Override
	public ServiceResponse<Employee> getOneById(String usuario) {
		Employee employee = employees.get(usuario);
		if(employee == null) {
			return new ServiceResponse<>(false);
		}
		return new ServiceResponse<>(true, employee);
	}

	
	@Override
	public ServiceResponse<List<Employee>> getAll() {
				
		return new ServiceResponse<>(true, new ArrayList<Employee>(employees.values()));
	}

	@Override
	public ServiceResponse<Void> upgradeEmployee(String usuario) {
		Employee employee = employees.get(usuario);
		if(employee == null) {
			return new ServiceResponse<>(false);
		}
		employee.setRol("admin");
		return new ServiceResponse<>(true);
	}

	@Override
	public ServiceResponse<Void> activateEmployee(String usuario) {
		Employee employee = employees.get(usuario);
		if(employee == null) {
			return new ServiceResponse<>(false);
		}
		employee.setActivo("inactivo");
		return new ServiceResponse<>(true);
	}

	@Override
	public ServiceResponse<Void> counterFaultsEmployee(String usuario) {
		Employee employee = employees.get(usuario);
		if(employee == null) {
			return new ServiceResponse<>(false);
		}
		employee.setFaltas(employee.getFaltas()+1);
		return new ServiceResponse<>(true);
	}

	@Override
	public ServiceResponse<Void> counterBonusEmployee(String usuario) {
		Employee employee = employees.get(usuario);
		if(employee == null) {
			return new ServiceResponse<>(false);
		}
		employee.setBonos(employee.getBonos()+1);
		return new ServiceResponse<>(true);
	}

	
	
	
}
