package ex2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ex2.entity.Employee;
import ex2.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class EmployeeService {
	EmployeeRepository employeeRepository;
	public List<Employee> getAll(){
		return employeeRepository.findAll();
	}
	public Employee add(Employee employee){
		return employeeRepository.save(employee);
	}
	public Employee delete(long id){
		Employee employee= employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee is not exist"));
		employeeRepository.deleteById(id);
		return employee;
	}
	public void delete(List<Long> ids){
		System.out.println( ids);
		ids.stream().forEach(id->{
			employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee is not exist"));
			employeeRepository.deleteById(id);
		});
	}
}
