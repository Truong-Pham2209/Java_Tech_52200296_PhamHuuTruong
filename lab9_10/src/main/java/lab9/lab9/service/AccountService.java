package lab9.lab9.service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lab9.lab9.Entity.AccountEntity;
import lab9.lab9.dto.AuthenticationRequest;
import lab9.lab9.dto.AuthenticationResponse;
import lab9.lab9.repo.AccountRepo;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AccountService {
	AccountRepo accountRepository;
	PasswordEncoder passwordEncoder;

	public AccountEntity create(AccountEntity accountEntity) {
		String password = passwordEncoder.encode(accountEntity.getPassword());
		accountEntity.setPassword(password);
		return accountRepository.save(accountEntity);
	}

	public AuthenticationResponse login(AuthenticationRequest authenticationRequest) {
		AccountEntity accountEntity = accountRepository.findByEmail(authenticationRequest.getEmail())
				.orElseThrow(() -> new RuntimeException("Account is not exist"));
		if (!passwordEncoder.matches(authenticationRequest.getPassword(), accountEntity.getPassword()))
			throw new RuntimeException("Password is not correct");
		return AuthenticationResponse.builder().authenticated(true).build();
	}
}
