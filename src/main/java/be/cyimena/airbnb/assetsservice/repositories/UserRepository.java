package be.cyimena.airbnb.assetsservice.repositories;

import be.cyimena.airbnb.assetsservice.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

    Page<User> findUserByFirstName(String firstName, Pageable pageable);
    Optional<User> findByAccount_Email(String email);


}
