package com.oleksii.blog.services;

import com.oleksii.blog.domain.entities.User;

import java.util.UUID;

public interface IUserService {
    User getUserByID(UUID id);
}
