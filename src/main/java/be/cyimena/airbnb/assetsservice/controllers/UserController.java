package be.cyimena.airbnb.assetsservice.controllers;

import be.cyimena.airbnb.assetsservice.models.User;
import be.cyimena.airbnb.assetsservice.services.impl.UserServiceImpl;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    UserServiceImpl userService;

    @GetMapping("/users/{id}")
    public User getUser(@PathVariable Integer id) {
        return this.userService.getUserById(id);
    }

    @GetMapping("/users")
    public Page<User> getUsers(Pageable pageable) {
        return this.userService.getUsers(pageable);
    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
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