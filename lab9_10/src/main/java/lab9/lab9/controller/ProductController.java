package lab9.lab9.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab9.lab9.Entity.ProductEntity;
import lab9.lab9.dto.ApiResponse;
import lab9.lab9.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@RestController
@RequestMapping("/api/products")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductController {
	ProductService productService;

	@GetMapping("")
	public ResponseEntity<ApiResponse<List<ProductEntity>>> getAll() {
		return new ResponseEntity<>(new ApiResponse<>(productService.getAll()), HttpStatus.OK);
	}

	@PostMapping("")
	public ResponseEntity<ApiResponse<ProductEntity>> create(@RequestBody ProductEntity productEntity) {
		return new ResponseEntity<>(new ApiResponse<>(productService.create(productEntity)), HttpStatus.CREATED);
	}

	@PutMapping("/{id}")
	public ResponseEntity<ApiResponse<ProductEntity>> replace(@PathVariable long id,
			@RequestBody ProductEntity productEntity) {
		return new ResponseEntity<>(new ApiResponse<>(productService.replace(id, productEntity)), HttpStatus.CREATED);
	}

	@PatchMapping("/{id}")
	public ResponseEntity<ApiResponse<ProductEntity>> update(@PathVariable long id,
			@RequestBody ProductEntity productEntity) {
		return new ResponseEntity<>(new ApiResponse<>(productService.update(id, productEntity)), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ApiResponse<ProductEntity>> delete(@PathVariable long id) {
		return new ResponseEntity<>(new ApiResponse<>(productService.delete(id)), HttpStatus.ACCEPTED);
	}
}
