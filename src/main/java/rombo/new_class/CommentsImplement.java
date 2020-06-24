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
	public CommentsImplement(final int IDUser, String Comment, Optional<Integer> IDComment, Optional<Integer> IDDiscussion,
			final Date data) {

		this.IDUser = IDUser;
		this.Comment = Comment;
		this.IDComment = IDComment;
		this.IDDiscussion = IDDiscussion;
		this.data = data;
	}
	

	/*Return methods*/
	
	public final String GetComment() {
		return this.Comment;
	}

	
	public final int GetIDUser() {
		return this.IDUser;
	}
	
	
	public final Optional<Integer> GetIDComment() {

		if (this.IDComment.isPresent()) {
			return this.IDComment;
		} else {
			return Optional.empty();
		}
	}

	
	
	public final Optional<Integer> GetIDDiscussion() {

		if (this.IDDiscussion.isPresent()) {
			return this.IDDiscussion;
		} else {
			return Optional.empty();
		}
	}


	public final int getIDUser() {
		return IDUser;
	}


	public final String getComment() {
		return Comment;
	}


	public final Optional<Integer> getIDComment() {
		return IDComment;
	}


	public final Optional<Integer> getIDDiscussion() {
		return IDDiscussion;
	}


	public final Date getData() {
		return data;
	}
	
	

}
