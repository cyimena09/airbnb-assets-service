package be.cyimena.airbnb.assetsservice.repositories;

import be.cyimena.airbnb.assetsservice.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface AccountRepository extends JpaRepository<Account, UUID> {
    Optional<Account> findByEmail(String email);
}

