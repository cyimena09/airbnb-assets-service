package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.exceptions.UserNotFoundException;
import be.cyimena.airbnb.assetsservice.mappers.IUserMapper;
import be.cyimena.airbnb.assetsservice.repositories.UserRepository;
import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import be.cyimena.airbnb.assetsservice.services.IUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.UUID;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;
    IUserMapper userMapper;

    @Override
    public Page<UserDto> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper.INSTANCE::mapToUserDto);
    }

    @Override
    public UserDto getUserById(UUID id) {
        return userMapper.INSTANCE.mapToUserDto(userRepository.findById(id).orElseThrow(() -> {
            throw new UserNotFoundException(id);
        }));
    }

    @Override
    public Page<UserDto> getUserByFilter(String firstName, Pageable pageable) {
        return userRepository.findUserByFirstName(firstName, pageable).map(userMapper.INSTANCE::mapToUserDto);
    }

    @Override
    public void createUser(UserDto user) {
        this.userRepository.save(userMapper.INSTANCE.mapToUser(user));
    }

    @Override
    public void updateUser(UserDto user) {
        userRepository.findById(user.getId()).map(t -> {
            t.setFirstName(user.getFirstName());
            t.setLastName(user.getLastName());
            return userRepository.save(t);
        }).orElseThrow(() -> new UserNotFoundException(user.getId()));
    }

    @Override
    public void deleteUser(UUID userId) {
        userRepository.findById(userId).map(t -> {
            userRepository.delete(t);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new UserNotFoundException(userId));
    }

}
