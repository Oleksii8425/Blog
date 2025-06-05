package com.oleksii.blog.services.impl;

import com.oleksii.blog.domain.entities.User;
import com.oleksii.blog.repositories.IUserRepository;
import com.oleksii.blog.services.IUserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public User getUserByID(UUID id) {
        return userRepository
                .findById(id)
                .orElseThrow(() ->
                        new EntityNotFoundException("User not found with id " + id)
                );
    }

}
