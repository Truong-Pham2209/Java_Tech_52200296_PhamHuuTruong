package ex2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ex2.entity.Employee;
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
