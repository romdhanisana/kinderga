package tn.esprit.esponline.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tn.esprit.esponline.model.VoteType;



@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoteDto {
	
	private VoteType voteType;
    private Long postId;
	/*public VoteType getVoteType() {
		return voteType;
	}
	public void setVoteType(VoteType voteType) {
		this.voteType = voteType;
	}
	public Long getPostId() {
		return postId;
	}
	public void setPostId(Long postId) {
		this.postId = postId;
	}*/
    
    
    

}
