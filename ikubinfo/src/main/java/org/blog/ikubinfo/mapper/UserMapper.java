package org.blog.ikubinfo.mapper;

import org.blog.ikubinfo.dto.UserDTO;
import org.blog.ikubinfo.model.User;
import java.time.LocalDateTime;

public class UserMapper {
    public static UserDTO toDto(User u){
        return UserDTO.builder()
                .id(u.getId())
                .email(u.getEmail())
                .username(u.getUsername())
                .build();

    }


    public static User toEntity(UserDTO userDTO){
        return User.builder()
                .dateCreated(LocalDateTime.now())
                .username(userDTO.getUsername())
                .email(userDTO.getEmail())
                .id(userDTO.getId())
                .build();

    }

    public static User toEntityForUpdate(User user, UserDTO userDTO){
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setDateModified(LocalDateTime.now());

        return user;
    }

}
