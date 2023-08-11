package com.example.carSale.service;

import com.example.carSale.entity.User;
import com.example.carSale.exception.EntityNotFoundException;
import com.example.carSale.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{
    private UserRepository userRepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public User getUser(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user,id);
    }

    @Override
    public User getUser(String username) {
        Optional<User> user = userRepository.findByUsername(username);
        return unwrapUser(user, 404);
    }

    @Override
    public User saveUsername(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }
    static User unwrapUser(Optional<User> entity, Integer id) {
        if (entity.isPresent()) return entity.get();
        else throw new EntityNotFoundException(id, User.class);
    }
}
