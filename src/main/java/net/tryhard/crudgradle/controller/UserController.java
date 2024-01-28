package net.tryhard.crudgradle.controller;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.mapper.UserMapper;
import net.tryhard.crudgradle.mapper.UserMapperImpl;
import net.tryhard.crudgradle.model.User;
import net.tryhard.crudgradle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//заменил все выводы с редиректа и Entity на UserDTO
@RestController
@RequiredArgsConstructor //zamena konstruktora s Autowired
public class UserController {

    private final UserService userService;



    @GetMapping("/users")
    public List<UserDTO> findAll() {
        return userService.findAll();

    }

    @PostMapping("/user-create")
    public UserDTO createUser(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }


    @GetMapping("user-delete/{id}") //вместо редиректа вывожу список всех пользователей
    public Long deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return id;
    }


    @GetMapping("/user-update/{id}")
    public UserDTO getUserForm(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PostMapping("/user-update")
    public UserDTO updateUser(UserDTO userDTO) {
        return userService.saveUser(userDTO);

    }

}
