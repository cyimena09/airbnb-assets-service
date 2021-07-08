package be.cyimena.airbnb.assetsservice.services.impl;

import be.cyimena.airbnb.assetsservice.domain.Profile;
import be.cyimena.airbnb.assetsservice.domain.User;
import be.cyimena.airbnb.assetsservice.enumerations.ProfileEnum;
import be.cyimena.airbnb.assetsservice.exceptions.AccountNotFoundException;
import be.cyimena.airbnb.assetsservice.exceptions.UserNotFoundException;
import be.cyimena.airbnb.assetsservice.mappers.IUserMapper;
import be.cyimena.airbnb.assetsservice.repositories.ProfileRepository;
import be.cyimena.airbnb.assetsservice.repositories.UserRepository;
import be.cyimena.airbnb.assetsservice.utils.Helper;
import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import be.cyimena.airbnb.assetsservice.services.IUserService;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    ProfileRepository profileRepository;
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

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByAccount_Email(email)
                .orElseThrow(() -> {
                    throw new AccountNotFoundException(email);
                });
        return userMapper.INSTANCE.mapToUserDto(user);
    }

    @Override
    public Page<UserDto> getUserByFilter(String firstName, Pageable pageable) {
        return userRepository.findUserByFirstName(firstName, pageable).map(userMapper.INSTANCE::mapToUserDto);
    }

    @Override
    public void createUser(UserDto userDto) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        Helper helper = new Helper(this.profileRepository);
        // When we map a user, to avoid a loop, we do not map the user in the account.
        // So we have to put it back "manually".
        User user = userMapper.INSTANCE.mapToUser(userDto);
        user.getAccount().setUser(user);
        user.getAccount().setPassword(passwordEncoder.encode(userDto.getAccount().getPassword()));
        user.getAccount().setProfiles(Set.of(Profile.builder().name(ProfileEnum.USER.toString()).build()));
        user.getAccount().setProfiles(helper.mergeProfiles(user.getAccount().getProfiles()));
        this.userRepository.save(user);
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
