package lab9.lab9.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab9.lab9.Entity.OrderEntity;
import lab9.lab9.dto.ApiResponse;
import lab9.lab9.service.OrderService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@RequestMapping("/api/orders")
public class OrderController {
	OrderService orderService;

	@GetMapping("")
	public ResponseEntity<ApiResponse<List<OrderEntity>>> getAll() {
		return new ResponseEntity<>(new ApiResponse<>(orderService.getAll()), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<ApiResponse<OrderEntity>> create(@RequestBody OrderEntity orderEntity) {
		return new ResponseEntity<>(new ApiResponse<>(orderService.create(orderEntity)), HttpStatus.CREATED);
	}
}
