package rombo.new_class;

import java.util.Date;
import java.util.Optional;

public class CommentsImplement implements Comments {
	
	/*Fields*/
	private final int IDUser;
	private final String Comment;
	private final Optional<Integer> IDComment;
	private final Optional<Integer> IDDiscussion;
	private final Date data;
	
	/*Builder*/
	public CommentsImplement(int IDUser, String Comment, Optional<Integer> IDComment,Optional<Integer> IDDiscussion, Date data) {
		
		this.IDUser = IDUser;
		this.Comment = Comment;
		this.IDComment = IDComment;
		this.IDDiscussion = IDDiscussion;
		this.data = data;
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


	public int getIDUser() {
		return IDUser;
	}


	public String getComment() {
		return Comment;
	}


	public Optional<Integer> getIDComment() {
		return IDComment;
	}


	public Optional<Integer> getIDDiscussion() {
		return IDDiscussion;
	}


	public Date getData() {
		return data;
	}
	
	

}
