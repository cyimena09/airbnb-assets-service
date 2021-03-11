package be.cyimena.airbnbassetsservice.services.impl;

import be.cyimena.airbnbassetsservice.exceptions.UserNotFoundException;
import be.cyimena.airbnbassetsservice.models.User;
import be.cyimena.airbnbassetsservice.repositories.UserRepository;
import be.cyimena.airbnbassetsservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public User createUser(User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User updateUser(Integer userId, User user) {
        return userRepository.findById(userId).map(t -> {
            t.setFirstName(user.getFirstName());
            t.setLastName(user.getLastName());
            return userRepository.save(t);
        }).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.findById(userId).map(t -> {
            userRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new UserNotFoundException(userId));
    }

}

