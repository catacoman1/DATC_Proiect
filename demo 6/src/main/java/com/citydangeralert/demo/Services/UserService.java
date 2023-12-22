package com.citydangeralert.demo.Services;

import com.citydangeralert.demo.Entities.Users;
import com.citydangeralert.demo.Repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<Integer> getUserPoints(Long userId) {
        return usersRepository.findById(String.valueOf(userId)).map(Users::getPoints);
    }

}