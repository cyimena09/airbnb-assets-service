package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import be.cyimena.airbnb.assetsservice.services.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

    @GetMapping("/users/by/filter")
    public Page<UserDto> getUserByFilter(Pageable pageable, @RequestParam(value = "firstName", required = false) String firstName) {
        return this.userService.getUserByFilter(firstName, pageable);
    }

    @PostMapping("/users")
    public void createUser(@RequestBody UserDto user) {
        System.out.println("Création de l'utilisateur");
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
