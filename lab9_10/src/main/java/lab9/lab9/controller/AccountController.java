package lab9.lab9.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lab9.lab9.Entity.AccountEntity;
import lab9.lab9.dto.ApiResponse;
import lab9.lab9.dto.AuthenticationRequest;
import lab9.lab9.dto.AuthenticationResponse;
import lab9.lab9.service.AccountService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/account")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountController {
	AccountService accountService;

	@PostMapping("/register")
	public ResponseEntity<ApiResponse<AccountEntity>> register(@RequestBody AccountEntity account) {
		return new ResponseEntity<>(new ApiResponse<>(accountService.create(account)), HttpStatus.CREATED);
	}

	@PostMapping("/login")
	public ResponseEntity<ApiResponse<AuthenticationResponse>> login(
			@RequestBody AuthenticationRequest authenticationRequest) {
		return new ResponseEntity<>(new ApiResponse<>(accountService.login(authenticationRequest)), HttpStatus.OK);
	}
}
