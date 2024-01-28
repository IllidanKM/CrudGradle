package net.tryhard.crudgradle.mapper;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ap.spi.MapStructProcessingEnvironment;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
@Mapper
public abstract class UserMapper {
    UserMapper INSTANCE= Mappers.getMapper(UserMapper.class);
    abstract User mapUser(UserDTO userDTO);

    public UserDTO  mapUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        return userDTO;

    }


}
