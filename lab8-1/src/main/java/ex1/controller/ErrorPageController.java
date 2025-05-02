package ex1.controller;

import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class ErrorPageController {
	@ExceptionHandler(NoResourceFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String notFound(Model model) {
		model.addAttribute("errorMessage", "Page not found");
		return "error";
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
	public String methodNotSupport(Model model) {
		model.addAttribute("errorMessage", "Method Not support");
		return "error";
 	}
}
