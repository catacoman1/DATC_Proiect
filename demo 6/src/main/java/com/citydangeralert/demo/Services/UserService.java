package com.citydangeralert.demo.Services;

import com.citydangeralert.demo.Entities.Users;
import com.citydangeralert.demo.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UsersRepository usersRepository;

    public Users saveUser(Users user) {
        return usersRepository.save(user);
    }


    public Users getUserById(String id) {

        Optional<Users> user = usersRepository.findById(id);

        if (user.isPresent()) {
            return user.get();
        } else {

            return null;
        }
    }


}