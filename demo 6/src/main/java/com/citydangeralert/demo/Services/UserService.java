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
    public Users updateUserPoints(Long id, int pointsToAdd) {
        Optional<Users> user = usersRepository.findById(String.valueOf(id));
        if (user.isPresent()) {
            Users updatedUser = user.get();
            updatedUser.setPoints(updatedUser.getPoints() + pointsToAdd); // Assuming you have a field 'points' in your Users entity
            return usersRepository.save(updatedUser);
        } else {
            return null;
        }
    }
    public Optional<Users> getUserByEmail(String email) {
        // Assuming you have a method in your repository to find a user by email
        return usersRepository.findByEmail(email);
    }

}