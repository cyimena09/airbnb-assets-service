package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

public interface IUserService {

    Page<UserDto> getUsers(Pageable pageable);

    UserDto getUserById(UUID userId);

    UserDto getUserByEmail(String email);

    Page<UserDto> getUserByFilter(String firstName, Pageable pageable);

    void createUser(UserDto User);

    void updateUser(UserDto user);

    void deleteUser(UUID userId);

}
