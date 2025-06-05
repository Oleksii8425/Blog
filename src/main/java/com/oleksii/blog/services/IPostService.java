package com.oleksii.blog.services;

import com.oleksii.blog.domain.CreatePostRequest;
import com.oleksii.blog.domain.entities.Post;
import com.oleksii.blog.domain.entities.User;

import java.util.List;
import java.util.UUID;

public interface IPostService {
    List<Post> getAllPosts(UUID categoryId, UUID tagId);
    List<Post> getDraftPosts(User user);
    Post createPost(User user, CreatePostRequest createPostRequest);
}
