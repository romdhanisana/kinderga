package tn.esprit.esponline.service;

import lombok.AllArgsConstructor;
import tn.esprit.esponline.dto.VoteDto;
import tn.esprit.esponline.exceptions.PostNotFoundException;
import tn.esprit.esponline.exceptions.SpringRedditException;
import tn.esprit.esponline.model.Post;
import tn.esprit.esponline.model.Vote;
import tn.esprit.esponline.repository.PostRepository;
import tn.esprit.esponline.repository.VoteRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static tn.esprit.esponline.model.VoteType.UPVOTE;

@Service
@AllArgsConstructor
public class VoteService {
	
	   private final VoteRepository voteRepository;
	    private final PostRepository postRepository;
	    private final AuthService authService;

	    @Transactional
	    public void vote(VoteDto voteDto) {
	        Post post = postRepository.findById(voteDto.getPostId())
	                .orElseThrow(() -> new PostNotFoundException("Post Not Found with ID - " + voteDto.getPostId()));
	        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());
	        if (voteByPostAndUser.isPresent() &&
	                voteByPostAndUser.get().getVotetype()
	                        .equals(voteDto.getVoteType())) {
	            throw new SpringRedditException("You have already "
	                    + voteDto.getVoteType() + "'d for this post");
	        }
	        if (UPVOTE.equals(voteDto.getVoteType())) {
	            post.setVoteCount(post.getVoteCount() + 1);
	        } else {
	            post.setVoteCount(post.getVoteCount() - 1);
	        }
	        voteRepository.save(mapToVote(voteDto, post));
	        postRepository.save(post);
	    }

	    private Vote mapToVote(VoteDto voteDto, Post post) {
	        return Vote.builder()
	                .votetype(voteDto.getVoteType())
	                .post(post)
	                .user(authService.getCurrentUser())
	                .build();
	    }

}
