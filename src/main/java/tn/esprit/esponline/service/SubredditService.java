package tn.esprit.esponline.service;


import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.esponline.dto.SubredditDto;
import tn.esprit.esponline.exceptions.SpringRedditException;
import tn.esprit.esponline.mapper.SubredditMapper;
import tn.esprit.esponline.model.Subreddit;
import tn.esprit.esponline.repository.SubredditRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
@AllArgsConstructor
@Slf4j
public class SubredditService {
	
	private final SubredditRepository subredditRepository;
    private final SubredditMapper subredditMapper;


    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit/*mapSubredditDto*/(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }
    

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto/*this::mapToDto*/)
                .collect(toList());
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
    
  /*  public Subreddit mapSubredditDto(SubredditDto subredditDto) {
    	return Subreddit.builder().name(subredditDto.getName())
    			.description(subredditDto.getDescription())
    			.build();
    }
    private SubredditDto  mapToDto(Subreddit subreddit){
    	
    	return SubredditDto.builder().name(subreddit.getName())
    			.id(subreddit.getId())
    			.numberOfPosts(subreddit.getPosts().size())
    			.build();
    }*/
    
    
    
    

}
