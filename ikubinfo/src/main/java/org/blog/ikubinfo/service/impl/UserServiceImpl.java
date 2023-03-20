package org.blog.ikubinfo.service.impl;

import org.blog.ikubinfo.dto.UserDTO;
import org.blog.ikubinfo.exceptions.BadRequestException;
import org.blog.ikubinfo.mapper.UserMapper;
import org.blog.ikubinfo.model.User;
import org.blog.ikubinfo.repository.UserRepository;
import org.blog.ikubinfo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static org.blog.ikubinfo.exceptions.ExceptionMessage.ENTITY_EXISTS;
import static org.blog.ikubinfo.exceptions.ExceptionMessage.NOT_FOUND;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll().stream().map(user -> UserMapper.toDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer id) {
        return userRepository.findById(id).map(user -> UserMapper.toDto(user)).orElseThrow(() -> new BadRequestException(String.format(NOT_FOUND, User.class.getSimpleName(), id)));
    }

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = userRepository.findByEmail(userDTO.getEmail()).orElse(null);
        if (user != null) {
            throw new BadRequestException(String.format(ENTITY_EXISTS, User.class.getSimpleName(), "email", userDTO.getEmail()));
        }
        return UserMapper.toDto(userRepository.save(UserMapper.toEntity(userDTO)));
    }

    @Override
    public UserDTO updateUserById(Integer id, UserDTO userDTO) {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException(String.format(NOT_FOUND, User.class.getSimpleName(), id)));
        return UserMapper.toDto(userRepository.save(UserMapper.toEntityForUpdate(user, userDTO)));
    }

    @Override
    public void deleteUserById(Integer id) {
        User user = userRepository.findById(id).orElseThrow(() -> new BadRequestException(String.format(NOT_FOUND, User.class.getSimpleName(), id)));
        userRepository.deleteById(id);
    }
}
