package ex2.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ex2.entity.Employee;
import ex2.repository.EmployeeRepository;
import ex2.service.EmployeeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Controller
@RequestMapping("/employees")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class EmployeeController {
	EmployeeService employeeService;
	EmployeeRepository employeeRepository;
	@GetMapping("")
	public String getAll(Model model) {
		List<Employee> employees = employeeService.getAll();
		model.addAttribute("employees", employees);
		return "index";
	}

	@PostMapping("/add")
	public String add(@ModelAttribute Employee employee) {
		employeeService.add(employee);
		return "redirect:/employees";
	}

	@GetMapping("/add")
	public String add() {
		return "add";
	}

	@PostMapping("/delete/{id}")
	public String delete(@PathVariable long id) {
		employeeService.delete(id);
		return "redirect:/employees";
	}
	@PostMapping("/delete/multiple")
	public String delete(@RequestParam List<Long> ids) {
		employeeService.delete(ids);
		return "redirect:/employees";
	}
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable long id,Model model){
		Employee employee = employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee is not exist"));
		model.addAttribute("employee", employee);
		return "edit";
	}
	@PostMapping("/edit/{id}")
	public String edit(@PathVariable long id,@ModelAttribute Employee employee){
		employee.setId(id);
		employeeService.add(employee);
		return "redirect:/employees";
	}
}
