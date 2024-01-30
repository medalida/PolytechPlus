package com.server.cinemaepul.utilisateur;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/me")
    public UtilisateurDTO getConnectedUser() {
        return this.userService.getConnectedUtilisateurDTO();
    }

    @GetMapping
    public List<User> findAll() {
        return this.userService.findAll();
    }

    @GetMapping("/{id}")
    public User getByIdOrThrow(@PathVariable("id") Integer userId) {
        return this.userService.getByIdOrThrow(userId);
    }

    @PostMapping
    public User create(@RequestBody User user) {
        return this.userService.create(user);
    }

    @PutMapping("/{id}")
    public User update(@PathVariable("id") Integer user_id, @RequestBody User user) {
        return this.userService.update(user_id, user);
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable("id") Integer utilisateurId) {
        return this.userService.delete(utilisateurId);
    }
}
