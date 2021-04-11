package be.cyimena.airbnb.assetsservice.controllers;

import be.cyimena.airbnb.assetsservice.models.User;
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
    public Page<User> getUsers(Pageable pageable) {
        return this.userService.getUsers(pageable);
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/users/by/filter")
    public Page<User> getUserByFilter(Pageable pageable, @RequestParam(value = "firstName", required = false) String firstName) {
        return this.userService.getUserByFilter(firstName, pageable);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        System.out.println("Création de l'utilisateur");
        return this.userService.createUser(user);
    }

    @PutMapping("users/{userId}")
    public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
        return this.userService.updateUser(userId, user);
    }

    @DeleteMapping("users/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
        this.userService.deleteUser(userId);
    }

}
