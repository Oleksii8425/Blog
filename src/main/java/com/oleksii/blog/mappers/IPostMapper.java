package com.oleksii.blog.mappers;

import com.oleksii.blog.domain.CreatePostRequest;
import com.oleksii.blog.domain.dtos.CreatePostRequestDto;
import com.oleksii.blog.domain.dtos.PostDto;
import com.oleksii.blog.domain.entities.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPostMapper {

    @Mapping(target = "author", source = "author")
    @Mapping(target = "category", source = "category")
    @Mapping(target = "tags", source = "tags")
    PostDto toDto(Post post);

    CreatePostRequest toCreatePostRequest(CreatePostRequestDto createPostRequestDto);

}
