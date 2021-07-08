package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import be.cyimena.airbnb.assetsservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/users")
    public Page<UserDto> getUsers(Pageable pageable) {
        return this.userService.getUsers(pageable);
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable UUID id) {
        return this.userService.getUserById(id);
    }

    @GetMapping(path = "/users/by/email/{userEmail}")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable(name = "userEmail") String email) {
        System.out.println(email);
        return new ResponseEntity<>(userService.getUserByEmail(email), HttpStatus.OK);
    }

    @GetMapping("/users/by/filter")
    public Page<UserDto> getUserByFilter(Pageable pageable, @RequestParam(value = "firstName", required = false) String firstName) {
        return this.userService.getUserByFilter(firstName, pageable);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserDto user) {
        this.userService.createUser(user);
    }

    @PutMapping("users")
    public void updateUser(@RequestBody UserDto user) {
        this.userService.updateUser(user);
    }

    @DeleteMapping("users/{userId}")
    public void deleteUser(@PathVariable UUID userId) {
        this.userService.deleteUser(userId);
    }

}
