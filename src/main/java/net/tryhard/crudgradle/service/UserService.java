package net.tryhard.crudgradle.service;

import net.tryhard.crudgradle.model.User;
import net.tryhard.crudgradle.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findById(Long id) {
        return userRepository.findById(id).orElse(null);  //getOne is old

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
