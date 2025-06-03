package com.oleksii.blog.services.impl;

import com.oleksii.blog.domain.entities.Tag;
import com.oleksii.blog.repositories.ITagRepository;
import com.oleksii.blog.services.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagService implements ITagService {

    private final ITagRepository tagRepository;

    @Override
    public List<Tag> getTags() {
        return tagRepository.findAllWithPostCount();
    }

}
