package com.oleksii.blog.services;

import com.oleksii.blog.domain.entities.Post;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
}
