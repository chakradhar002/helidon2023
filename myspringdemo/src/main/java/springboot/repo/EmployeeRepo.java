package springboot.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import springboot.pojo.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	
	
	
}
