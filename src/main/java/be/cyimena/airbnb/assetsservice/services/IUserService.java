package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<UserDto> getUsers(Pageable pageable);

    UserDto getUserById(Integer userId);

    Page<UserDto> getUserByFilter(String firstName, Pageable pageable);

    UserDto createUser(UserDto User);

    UserDto updateUser(Integer userId, UserDto user);

    void deleteUser(Integer userId);

}
