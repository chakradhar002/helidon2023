package springboot.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import springboot.pojo.Employee;
import springboot.repo.EmployeeRepo;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepo repo;

		
	public Employee addEmployee(Employee emp) {

		Employee result = repo.save(emp);
		return result;

	}
	
	// Update Employee
    public Employee updateEmployee(Long id, Employee employeeDetails) {
        Optional<Employee> optionalEmployee = repo.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employee.setName(employeeDetails.getName());
         
            return repo.save(employee);
        } else {
            return null; // Handle not found case
        }
    }
	
	// Get All Employees
    public List<Employee> getAllEmployees() {
        return repo.findAll();
    }
	

}
