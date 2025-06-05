package com.oleksii.blog.services;

import com.oleksii.blog.domain.entities.Tag;

import java.util.List;
import java.util.Set;

public interface ITagService {
    List<Tag> getTags();
    List<Tag> createTags(Set<String> tagNames);
}
