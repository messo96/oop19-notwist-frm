package notwist.base;

import java.util.Optional;

import rombo.discuss.BaseAccountImplements;

public class CommentsImplements extends BaseAccountImplements implements Comments{

	/*Fields.*/
	private final String Comment;
	private String Topic = null;
	private int number = 0;
	
	/*Builders.*/
	
	/*Base builder.*/
	public CommentsImplements(int ID, String Comment) {
		super(ID);
		this.Comment = Comment;
	}
	
	/*Advance builders.*/
	
	/*(1)*/
	public CommentsImplements(int ID, String UserName , String Comment) {
		super(ID,UserName);
		this.Comment = Comment;
	}
	
	/*(2)*/
	public CommentsImplements(int ID, String UserName , String Comment, String Topic) {
		super(ID,UserName);
		this.Comment = Comment;
		this.Topic = Topic;
	}
	
	/*(3)*/
	public CommentsImplements(int ID, String UserName , String Comment, String Topic , int NumberOfComment) {
		super(ID,UserName);
		this.Comment = Comment;
		this.Topic = Topic;
		this.number = NumberOfComment;
	}
	

	/*Return methods.*/
	
	public String GetComment() {
		
		return this.Comment;
	}

	public Optional<String> GetTopic() {
		if(this.Topic != null) {
			return Optional.of(this.Topic);
		}
		else {
			return Optional.empty();
		}
	}

	public Optional<Integer> GetNumberOfCommet() {
		if(this.number !=0) {
			return Optional.of(this.number);
		}
		else {
		return Optional.empty();
		}
	}
}
