package tn.esprit.esponline.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tn.esprit.esponline.dto.CommentsDto;
import tn.esprit.esponline.model.Comment;
import tn.esprit.esponline.model.Post;
import tn.esprit.esponline.model.User;

@Mapper(componentModel = "spring")
public interface CommentMapper {
	
	@Mapping(target = "id", ignore = true)
    @Mapping(target = "text", source = "commentsDto.text")
    @Mapping(target = "createdDate", expression = "java(java.time.Instant.now())")
    @Mapping(target = "post", source = "post")
    @Mapping(target = "user", source = "user")
    Comment map(CommentsDto commentsDto, Post post, User user);

    @Mapping(target = "postId", expression = "java(comment.getPost().getPostId())")
    @Mapping(target = "userName", expression = "java(comment.getUser().getUsername())")
    CommentsDto mapToDto(Comment comment);

}
