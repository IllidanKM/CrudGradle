package net.tryhard.crudgradle.controller;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.dto.UserDTOCreate;
import net.tryhard.crudgradle.dto.UserDTOUpdate;
import net.tryhard.crudgradle.mapper.UserMapper;
import net.tryhard.crudgradle.mapper.UserMapperImpl;
import net.tryhard.crudgradle.model.User;
import net.tryhard.crudgradle.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;



    @GetMapping("/users")
    public List<UserDTO> findAll() {
        return userService.findAll();

    }

    @PostMapping("/user-create")
    public UserDTO createUser(@RequestBody UserDTOCreate userDTOCreate) {
        return userService.saveUser(userDTOCreate);
    }


    @DeleteMapping("user-delete/{id}")
    public Long deleteUser(@PathVariable("id") Long id) {
        userService.deleteById(id);
        return id;
    }


    @GetMapping("/user-get/{id}")
    public UserDTO getUserForm(@PathVariable("id") Long id) {
        return userService.findById(id);
    }

    @PutMapping("/user-update")
    public UserDTO updateUser(@RequestParam Long id,UserDTOUpdate userDTOUpdate) {
        return userService.updateUser(id,userDTOUpdate);

    }

}
