package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.exceptions.UserNotFoundException;
import be.cyimena.airbnb.assetsservice.repositories.UserRepository;
import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import be.cyimena.airbnb.assetsservice.services.IUserService;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

@Service
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<UserDto> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public UserDto getUserById(Integer userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException(userId));
    }

    @Override
    public Page<UserDto> getUserByFilter(String firstName, Pageable pageable) {
        return userRepository.findUserByFirstName(firstName, pageable);
    }

    @Override
    public UserDto createUser(UserDto user) {
        return this.userRepository.save(user);
    }

    @Override
    public UserDto updateUser(Integer userId, UserDto user) {
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

