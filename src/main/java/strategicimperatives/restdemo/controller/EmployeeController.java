package strategicimperatives.restdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import strategicimperatives.restdemo.model.Employee;
import strategicimperatives.restdemo.repository.EmployeeRepository;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(@RequestBody Employee employee) {
		return employeeRepository.saveEmployee(employee);
	}
	
	@GetMapping("/getEmployeeById/{id}")
	public Employee getEmployeeById(@PathVariable("id") String employeeId){
		return employeeRepository.getEmployeeById(employeeId);
	}
	
	@DeleteMapping("/deleteEmployeeById/{id}")
	public String deleteEmployeeById(@PathVariable("id") String employeeId) {
		return employeeRepository.deleteEmployeeById(employeeId);
	}
	
	@PutMapping("/updateEmployeeById/{id}")
	public Employee updateEmployeeById(@PathVariable("id") String employeeId, @RequestBody Employee employee) {
		return employeeRepository.updateEmployeeById(employeeId, employee);
	}
	
	@GetMapping("/getAllEmployee")
	public List<Employee> getAllEmployee(){
		return employeeRepository.getAllEmployee();
	}
}
