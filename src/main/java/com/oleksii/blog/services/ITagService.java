package com.oleksii.blog.services;

import com.oleksii.blog.domain.entities.Tag;

import java.util.List;

public interface ITagService {
    List<Tag> getTags();
}
