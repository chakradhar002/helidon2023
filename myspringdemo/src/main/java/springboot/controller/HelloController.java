package springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import springboot.pojo.Employee;
import springboot.service.EmployeeService;

@RestController
public class HelloController {

	@Autowired
	EmployeeService empservice;

	@GetMapping("/")
	public String hello() {
		return "Hello, World!";
	}

	@PostMapping("/addemployee")
	public Employee addEmployee(@RequestBody Employee emp) {

		Employee result = empservice.addEmployee(emp);

		return result;

	}
	
	 // Update Employee (PUT)
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
        Employee updatedEmployee = empservice.updateEmployee(id, employeeDetails);
        return updatedEmployee != null ? ResponseEntity.ok(updatedEmployee) : ResponseEntity.notFound().build();
    }
	
	
	
	 // Get All Employees (GET)
    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return empservice.getAllEmployees();
    }

	

}