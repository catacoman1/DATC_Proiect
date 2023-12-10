package com.citydangeralert.demo.Services;

import com.citydangeralert.demo.Entities.UserEntity;
import com.citydangeralert.demo.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private UsersRepository usersRepository;

    public UserEntity saveUser(UserEntity user) {
        return usersRepository.save(user);
    }


}