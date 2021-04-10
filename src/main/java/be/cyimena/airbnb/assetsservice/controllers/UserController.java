package be.cyimena.airbnb.assetsservice.controllers;

import be.cyimena.airbnb.assetsservice.models.RealEstate;
import be.cyimena.airbnb.assetsservice.models.User;
import be.cyimena.airbnb.assetsservice.repositories.UserRepository;
import be.cyimena.airbnb.assetsservice.services.impl.UserServiceImpl;
import org.hibernate.service.spi.InjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable Integer id) {
        return this.userRepository.findById(id).orElseThrow();
        //return this.userService.getUserById(id);
    }
//
//    @GetMapping("/users")
//    public Page<User> getUsers(Pageable pageable) {
//        return this.userService.getUsers(pageable);
//    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        System.out.println("Création de l'utilisateur");
        return this.userRepository.save(user);
    }

//    @PutMapping("users/{userId}")
//    public User updateUser(@PathVariable Integer userId, @RequestBody User user) {
//        return this.userService.updateUser(userId, user);
//    }
//
//    @DeleteMapping("users/{userId}")
//    public void deleteUser(@PathVariable Integer userId) {
//        this.userService.deleteUser(userId);
//    }

}
