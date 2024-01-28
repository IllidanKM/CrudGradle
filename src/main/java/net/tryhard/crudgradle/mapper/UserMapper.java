package net.tryhard.crudgradle.mapper;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTO;
import net.tryhard.crudgradle.dto.UserDTOCreate;
import net.tryhard.crudgradle.dto.UserDTOUpdate;
import net.tryhard.crudgradle.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ap.spi.MapStructProcessingEnvironment;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import javax.swing.*;


@RequiredArgsConstructor
@Mapper(componentModel = "spring")


public abstract class UserMapper {

    public abstract User mapUser(UserDTO userDTO);

    public abstract UserDTO mapUserDTO(User user) ;

    public abstract UserDTO mapUserDTO(UserDTOUpdate userDTOUpdate) ;
    public abstract UserDTO mapUserDTO(UserDTOCreate userDTOCreate) ;
    public abstract User mapUser(UserDTOUpdate userDTOUpdate) ;
    public abstract User mapUser(UserDTOCreate userDTOCreate) ;



}
