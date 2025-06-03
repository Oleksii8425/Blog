package com.oleksii.blog.controllers;

import com.oleksii.blog.domain.dtos.TagRepsonse;
import com.oleksii.blog.domain.entities.Tag;
import com.oleksii.blog.mappers.TagMapper;
import com.oleksii.blog.services.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/tags")
@RequiredArgsConstructor
public class TagController {

    private final ITagService tagService;
    private final TagMapper tagMapper;

    @GetMapping
    public ResponseEntity<List<TagRepsonse>> getAllTags() {
        List<Tag> tags = tagService.getTags();
        List<TagRepsonse> tagResponses = tags.stream().map(tagMapper::toTagResponse).toList();
        return ResponseEntity.ok(tagResponses);
    }

}
