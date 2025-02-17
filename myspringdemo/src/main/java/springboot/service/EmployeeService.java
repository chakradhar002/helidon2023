package springboot.service;

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

}
