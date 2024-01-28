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
    public List<UserDTO> findAll(Model model) {
        List<UserDTO> usersDto = userService.findAll();
        model.addAttribute("users", usersDto);

        return usersDto;

    }

    @GetMapping("/user-create")
    public UserDTO createUserForm(User user) {
        var mapper = new UserMapperImpl();
        return mapper.mapUserDTO(user);
    }

    @PostMapping("/user-create")
    public UserDTO createUser(@RequestBody User user) {

        UserDTO userDTO= userService.saveUser(user);
        return userDTO;
    }

    @GetMapping("user-delete/{id}") //вместо редиректа вывожу список всех пользователей
    public List<UserDTO> deleteUser(@PathVariable("id") Long id){
        userService.deleteById(id);
        List<UserDTO> usersDto = userService.findAll();
        return usersDto;
    }
    @GetMapping("/user-update/{id}")
    public UserDTO updateUserForm(@PathVariable("id") Long id,Model model){
        UserDTO userDTO = userService.findById(id);
        model.addAttribute("user",userDTO);
        return userService.findById(id);
    }
    @PostMapping("/user-update")
    public UserDTO updateUser(User user){
       UserDTO userDTO= userService.saveUser(user);
        return userDTO;
    }

}
