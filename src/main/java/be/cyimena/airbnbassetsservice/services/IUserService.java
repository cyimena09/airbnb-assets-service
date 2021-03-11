package be.cyimena.airbnbassetsservice.services;

import be.cyimena.airbnbassetsservice.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IUserService {

    Page<User> getUsers(Pageable pageable);

    User getUserById(Integer userId);

    User createUser(User User);

    User updateUser(Integer userId, User user);

    void deleteUser(Integer userId);

}
