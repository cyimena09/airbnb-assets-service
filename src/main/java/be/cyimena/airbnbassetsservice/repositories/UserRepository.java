package be.cyimena.airbnbassetsservice.repositories;

import be.cyimena.airbnbassetsservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
