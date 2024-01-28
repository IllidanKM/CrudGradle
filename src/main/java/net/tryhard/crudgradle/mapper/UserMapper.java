package net.tryhard.crudgradle.mapper;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.model.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Mapper
public abstract class UserMapper {
    public UserDTO  mapUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        return userDTO;

    }

}
