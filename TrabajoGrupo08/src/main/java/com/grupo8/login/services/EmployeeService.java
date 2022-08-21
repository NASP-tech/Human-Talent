package com.grupo8.login.services;

import java.util.List;

import com.grupo8.login.services.utils.ServiceResponse;
import com.grupo8.models.entities.Employee;

public interface EmployeeService {
	ServiceResponse<Void> insert(Employee employee);
	ServiceResponse<Employee> getOneById(String usuario);
	ServiceResponse<List <Employee>> getAll();
	ServiceResponse<Void> upgradeEmployee(String usuario);
	ServiceResponse<Void> activateEmployee(String usuario);
	ServiceResponse<Void> counterFaultsEmployee(String usuario);
	ServiceResponse<Void> counterBonusEmployee(String usuario);
}
