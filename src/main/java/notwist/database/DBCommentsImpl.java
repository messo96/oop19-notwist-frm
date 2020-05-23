package notwist.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import notwist.base.Comments;
import notwist.base.CommentsImplements;
import notwist.base.Discussion;
import notwist.base.DiscussionImpl;
import notwist.base.User;

public class DBCommentsImpl extends DBManagerImpl{

	private ResultSet rs = null;
    private String query;
	
	public Optional<List<Comments>> getCommentfromDiscussion(final Integer idDiscussion){
		List<Comments> list = new LinkedList<>();
		
		try {
			query = "select * from DISCUSSION where idDiscussion= "+ idDiscussion;
			rs = open().executeQuery(query);
		 
	              
	     while (rs.next()) {
//	    	list.add(new CommentsImplements())
	     }
		}
	     catch(SQLException e) {
//	    	 System.out.println("Error while download discussion of " + user.toString() + "\n"+e);
	     }
		finally {
			close();
		}
			return Optional.of(list);
	}
}
