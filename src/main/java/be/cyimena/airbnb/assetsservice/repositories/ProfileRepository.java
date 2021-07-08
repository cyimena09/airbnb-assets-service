package be.cyimena.airbnb.assetsservice.repositories;

import be.cyimena.airbnb.assetsservice.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProfileRepository extends JpaRepository<Profile, UUID> {

    Optional<Profile> findByName(String name);

}
