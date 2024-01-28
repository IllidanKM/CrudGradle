package net.tryhard.crudgradle.service;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.mapper.UserMapper;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.mapper.UserMapperImpl;
import net.tryhard.crudgradle.model.User;
import net.tryhard.crudgradle.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapperImpl userMapper;
    private final UserRepository userRepository;


    public UserDTO findById(Long id) {
        return userRepository.findById(id)
                .map(userMapper::mapUserDTO)
                .orElse(null);
    }

    public List<UserDTO> findAll() {

        return userRepository.findAll().
                stream()
                .map(userMapper::mapUserDTO)
                .toList();
    }

    public UserDTO saveUser(UserDTO userDTO) {
        return userMapper.mapUserDTO(userRepository.save(userMapper.mapUser(userDTO)));

    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);

    }



}
