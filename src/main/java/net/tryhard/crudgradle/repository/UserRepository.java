package net.tryhard.crudgradle.repository;

import net.tryhard.crudgradle.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
}
