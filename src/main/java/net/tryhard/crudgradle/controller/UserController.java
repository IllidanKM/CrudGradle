package net.tryhard.crudgradle.controller;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.model.User;
import net.tryhard.crudgradle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor //zamena konstruktora s Autowired
public class UserController {

    private final UserService userService;

    @GetMapping("/users")
    public List<User> findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);

        return users;

    }

    @GetMapping("/user-create")
    public User createUserForm(User user) {
        return user;
    }

    @PostMapping("/user-create")
    public String createUser(@RequestBody User user) {

        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("user-delete/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        return "redirect:/users";
    }
    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") Long id,Model model){
        UserDTO userDTO = userService.findById(id);
        model.addAttribute("user",userDTO);
        return"/user-update";
    }
    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

}
