package ex1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
	@GetMapping("/")
	public String home() {
		return "index";
	}

	@GetMapping("/contact")
	public String getContact() {
		return "contact";
	}

	@PostMapping("/contact")
	public String postContact(@RequestParam String fullName, @RequestParam String password, Model model) {
		model.addAttribute("fullName", fullName);
		model.addAttribute("password", password);
		return "information";
	}

	@GetMapping("/about")
	public String about() {
		return "about";
	}

}
