package be.cyimena.airbnb.assetsservice.services;

import be.cyimena.airbnb.assetsservice.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> getUsers(Pageable pageable);

    User getUserById(Integer userId);

    Page<User> getUserByFilter(String firstName, Pageable pageable);

    User createUser(User User);

    User updateUser(Integer userId, User user);

    void deleteUser(Integer userId);

}
