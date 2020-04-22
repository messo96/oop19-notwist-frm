package notwist.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import notwist.base.Category;
import notwist.base.Discussion;
import notwist.base.User;

public class DBDiscussionImpl extends DBManagerImpl implements DBDiscussion{

	
	private ResultSet rs = null;
    private String query;
	
    
	public Optional<List<Discussion>> getDiscussion(final User user){
		List<Discussion> discussion = new LinkedList<>();
		
		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);
		 
	              
	     while (rs.next()) {
	    	 if(rs.getInt("id_creator") == (user.getId()))
	       	discussion.add(new Discussion(user.getId(),rs.getString("title"), rs.getString("description")));
	     }
		}
	     catch(SQLException e) {
	    	 System.out.println("Error while download discussion of " + user.toString() + "\n"+e);
	     }
		finally {
			close();
		}
		if(discussion.isEmpty())
			return Optional.empty();
		else
			return Optional.of(discussion);
	}
	
	public boolean createDiscussion(final User user, final Discussion discussion, final Category topic) {			
		 try {
			 
			 	PreparedStatement prepared = super.getConn()
		        		.prepareStatement("insert into DISCUSSION (id_creator,title,description,id_macro) values (?,?,?,?)");
		     	prepared.setInt(1,user.getId());
		        prepared.setString(2, discussion.getTitle());
		     	prepared.setString(3, discussion.getDescription());
		     	prepared.setInt(4,topic.getId());
		     	
		     	prepared.executeUpdate();
		     	System.out.println("Discussion create successfully(" + discussion.getTitle() + " | " + user.getUsername());
		     	return true;
		}
		catch(Exception e) {
			System.out.println("\nError while adding new user " + e);
			return false;
		}
		finally {
			close();
		}
	}

	@Override
	public Optional<List<Discussion>> getAllDiscussion() {
		List<Discussion> discussion = new LinkedList<>();
		
		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);
		 
	              
	     while (rs.next()) {
	    		discussion.add(new Discussion(rs.getInt("id_user"),rs.getString("title"), rs.getString("description")));
	     }
		}
	     catch(SQLException e) {
	    	 System.out.println("Error while download discussion"+e);
	     }
		finally {
			close();
		}
		if(discussion.isEmpty())
			return Optional.empty();
		else
			return Optional.of(discussion);
	}
	
	

	
}
