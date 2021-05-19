package tn.esprit.esponline.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import tn.esprit.esponline.dto.SubredditDto;
import tn.esprit.esponline.model.Post;
import tn.esprit.esponline.model.Subreddit;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubredditMapper {
	
	@Mapping(target = "numberOfPosts", expression = "java(mapPosts(subreddit.getPosts()))")
    SubredditDto mapSubredditToDto(Subreddit subreddit);

    default Integer mapPosts(List<Post> numberOfPosts) {
        return numberOfPosts.size();
    }

    @InheritInverseConfiguration
    @Mapping(target = "posts", ignore = true)
    Subreddit mapDtoToSubreddit(SubredditDto subredditDto);

}
