package com.employee.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.backend.model.Employee;
import com.employee.backend.service.EmployeeService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1/")
public class EmployeeController {

	@Autowired
	private EmployeeService employeerService;
	
	@GetMapping("employees")
	public List<Employee> getAllEmployees() {
		return employeerService.getAllEmployees();
	}
	
	@PostMapping("employees")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeerService.addEmployee(employee);
	}
	
	@GetMapping("employees/{id}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Long id) {
		Employee employee = employeerService.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}
	
	@PutMapping("employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable Long id,@RequestBody Employee employee) {
		Employee updatedEmployee = employeerService.updateEmployee(id,employee);
		return ResponseEntity.ok(updatedEmployee);
	}
	
	@DeleteMapping("employees/{id}")
	public ResponseEntity<Employee> deleteEmployee(@PathVariable Long id) {
		Employee employee = employeerService.deleteEmployee(id);
		return ResponseEntity.ok(employee);
	}
	
}
