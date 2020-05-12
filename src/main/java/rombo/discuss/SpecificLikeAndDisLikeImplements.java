package rombo.discuss;

import java.util.Optional;

import notwist.base.CommentsImplements;

public class SpecificLikeAndDisLikeImplements extends LikeAndDislikeImplements implements SpecificLikeAndDisLike {

	/*Fileds.*/
	private final String Topic;
	private CommentsImplements Comment = null;
	
	/*Base builder.*/
	public SpecificLikeAndDisLikeImplements(String Topic) {
		super();
		this.Topic = Topic;
	}
	
	/*Advance builder.*/
	public SpecificLikeAndDisLikeImplements(String Topic, CommentsImplements Comment) {
		super();
		this.Topic = Topic;
		this.Comment = Comment;
	}


	/*Getter methods.*/
	
	/*This method return the topic.*/
	public String GetTopic() {
		return this.Topic;
	}


	/*If possible this method return the comment.*/
	public Optional<CommentsImplements> GetComment() {
		
		if(this.Comment != null) {
			return Optional.of(this.Comment);
		}
		else {
			return Optional.empty();
		}
		
	}

}
