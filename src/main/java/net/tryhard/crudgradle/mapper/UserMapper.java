package net.tryhard.crudgradle.mapper;

import lombok.RequiredArgsConstructor;
import net.tryhard.crudgradle.dto.UserDTO;
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



}
