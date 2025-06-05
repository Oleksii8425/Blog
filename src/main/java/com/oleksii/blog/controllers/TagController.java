package com.oleksii.blog.controllers;

import com.oleksii.blog.domain.dtos.CreateTagsRequest;
import com.oleksii.blog.domain.dtos.TagRepsonse;
import com.oleksii.blog.domain.entities.Tag;
import com.oleksii.blog.mappers.TagMapper;
import com.oleksii.blog.services.ITagService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

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

    @PostMapping
    public ResponseEntity<List<TagRepsonse>> createTags(@RequestBody CreateTagsRequest createTagsRequest) {
        List<Tag> savedTags = tagService.createTags(createTagsRequest.getNames());
        List<TagRepsonse> createdTagResponses = savedTags.stream()
                .map(tagMapper::toTagResponse)
                .toList();

        return new ResponseEntity<>(createdTagResponses, HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable UUID id) {
        tagService.deleteTag(id);
        return ResponseEntity.noContent().build();
    }

}
