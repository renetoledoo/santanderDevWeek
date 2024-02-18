package org.api.rt.DevWeek.service.Impl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.api.rt.DevWeek.model.User;
import org.api.rt.DevWeek.repository.UserRepository;
import org.api.rt.DevWeek.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User findById(Long id) {
        Optional<User> usuario = userRepository.findById(id);
        return usuario.orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        
        if(userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Este número da conta já existe.");
        } 
        userRepository.save(userToCreate);
        return userToCreate;
    }
    
}
