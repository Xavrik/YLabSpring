package com.edu.ulab.app.service.impl;

import com.edu.ulab.app.dto.BookDto;
import com.edu.ulab.app.dto.UserDto;
import com.edu.ulab.app.entity.User;
import com.edu.ulab.app.service.UserService;
import com.edu.ulab.app.storage.Storage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserDto createUser(UserDto userDto) {
        int id = (int) System.currentTimeMillis();
        Storage store = new Storage();
        User user = new User(
                id,
                userDto.getFullName(),
                userDto.getTitle(),
                userDto.getAge()
        );
        userDto.setId((long) id);
        store.addUser(user);

       store.printUser();
        store.printBook();

        return userDto;
    }

    @Override
    public UserDto updateUser(UserDto userDto) {

        Storage storage = new Storage();
        storage.printUser();
        storage.getUsersName(userDto.getFullName(), userDto.getTitle());

        return userDto;
    }

    @Override
    public UserDto getUserById(Long id) {
        return null;
    }

    @Override
    public void deleteUserById(Long id) {

    }
}
