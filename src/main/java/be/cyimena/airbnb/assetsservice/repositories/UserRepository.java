package be.cyimena.airbnb.assetsservice.repositories;

import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserDto, Integer> {

    Page<UserDto> findUserByFirstName(String firstName, Pageable pageable);

}
