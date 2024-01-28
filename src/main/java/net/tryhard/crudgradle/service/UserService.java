package net.tryhard.crudgradle.service;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.mapper.UserMapper;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.model.User;
import net.tryhard.crudgradle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapper userMapper;
    private final UserRepository userRepository;



    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapUserDTO)
                .orElse(null);
    }

    public List<User> findAll() {
        return userRepository.findAll();

    }

    public User saveUser(User user) {
        return userRepository.save(user);

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }
}
