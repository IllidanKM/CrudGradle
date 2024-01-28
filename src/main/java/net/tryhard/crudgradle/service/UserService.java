package net.tryhard.crudgradle.service;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTOCreate;
import net.tryhard.crudgradle.dto.UserDTOUpdate;
import net.tryhard.crudgradle.exception.NotFoundException;
import net.tryhard.crudgradle.mapper.UserMapper;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.mapper.UserMapperImpl;
import net.tryhard.crudgradle.model.User;
import net.tryhard.crudgradle.repository.UserRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.awt.print.Pageable;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserMapperImpl userMapper;
    private final UserRepository userRepository;


    public UserDTO findById(Long id) throws NotFoundException {
        return userRepository.findById(id)
                .map(userMapper::mapUserDTO)
                .orElseThrow(() -> new NotFoundException("user with id " +id + " not found." ));
    }

    public List<UserDTO> findAll(int pageNumber,int pageSize) {
        if (pageSize> 50){
            pageSize= 50;
        } else if (pageSize<0) {
            pageSize = 0;

        }

        return userRepository.findAll(PageRequest.of(pageNumber,pageSize))
                .stream()
                .map(userMapper::mapUserDTO)
                .toList();
    }

    public UserDTO saveUser(UserDTOCreate userDTOCreate) {
        User user = userRepository.save(userMapper.mapUser(userDTOCreate));
        return userMapper.mapUserDTO(user);

    }

    public UserDTO updateUser(Long id, UserDTOUpdate userDTOUpdate) throws NotFoundException {
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("user with id " +id + " not found." ));
        user.setFirstName(userDTOUpdate.getFirstName());
        user.setLastName(userDTOUpdate.getLastName());
        return userMapper.mapUserDTO(userRepository.save(user));
    }

    public void deleteById(Long id) throws NotFoundException{
        User user = userRepository.findById(id).orElseThrow(() -> new NotFoundException("You are trying to delete a non-existing user."));

        userRepository.deleteById(id);

    }


}
