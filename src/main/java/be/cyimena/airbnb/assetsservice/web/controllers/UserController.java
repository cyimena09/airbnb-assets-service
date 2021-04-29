package be.cyimena.airbnb.assetsservice.web.controllers;

import be.cyimena.airbnb.assetsservice.web.models.UserDto;
import be.cyimena.airbnb.assetsservice.services.IUserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/assets")
public class UserController {

    private final IUserService userService;

    // CONSTRUCTOR

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    // METHODS

    @GetMapping("/users")
    public Page<UserDto> getUsers(Pageable pageable) {
        return this.userService.getUsers(pageable);
    }

    @GetMapping("/users/{id}")
    public UserDto getUserById(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/users/by/filter")
    public Page<UserDto> getUserByFilter(Pageable pageable, @RequestParam(value = "firstName", required = false) String firstName) {
        return this.userService.getUserByFilter(firstName, pageable);
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto user) {
        System.out.println("Création de l'utilisateur");
        return this.userService.createUser(user);
    }

    @PutMapping("users/{userId}")
    public UserDto updateUser(@PathVariable Integer userId, @RequestBody UserDto user) {
        return this.userService.updateUser(userId, user);
    }

    @DeleteMapping("users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
    }

}
