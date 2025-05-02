package lab9.lab9.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lab9.lab9.entity.AccountEntity;

@Repository
public interface AccountRepo extends JpaRepository<AccountEntity, Long> {
	Optional<AccountEntity> findByEmail(String email);
}
