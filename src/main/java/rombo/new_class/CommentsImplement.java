package rombo.new_class;

import java.util.Optional;

public class CommentsImplement implements Comments {
	
	/*Fields*/
	private final int IDUser;
	private final String Comment;
	private final Optional<Integer> IDComment;
	private final Optional<Integer> IDDiscussion;
	
	
	/*Builder*/
	public CommentsImplement(int IDUser, String Comment, Optional<Integer> IDComment,Optional<Integer> IDDiscussion) {
		
		this.IDUser = IDUser;
		this.Comment = Comment;
		this.IDComment = IDComment;
		this.IDDiscussion = IDDiscussion;
	}
	

	/*Return methods*/
	
	public String GetComment() {
		return this.Comment;
	}

	
	public int GetIDUser() {
		return this.IDUser;
	}
	
	
	public Optional<Integer> GetIDComment() {
		
		if(this.IDComment.isPresent()) {
			return this.IDComment;
		}
		else {
			return Optional.empty();
		}
	}

	
	
	public Optional<Integer> GetIDDiscussion() {
		
		if(this.IDDiscussion.isPresent()) {
			return this.IDDiscussion;
		}
		else {
			return Optional.empty();
		}
	}

}
