package org.blog.ikubinfo.service;

import org.blog.ikubinfo.dto.UserDTO;
import org.blog.ikubinfo.model.User;

import java.util.List;

public interface UserService {

    List<UserDTO> getUsers();
    UserDTO getUserById(Integer id);
    UserDTO createUser(UserDTO userDTO);
    UserDTO updateUserById(Integer id, UserDTO userDTO);
    void deleteUserById(Integer id);

}
