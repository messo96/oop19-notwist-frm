package notwist.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

public class DBDiscussion extends DBManagerImpl{

	
	private ResultSet rs = null;
    private String query;
	/**
	 * 
	 * @param idUser
	 * 			identifier of user that create the return discussion
	 * @return
	 * 			null if user hasn't create a discussion, the discussion otherwise
	 */
	public List<Discussion> getDiscussion(User user) {
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
	    	 System.out.println("Error while download discussion"+e);
	     }
		finally {
			close();
		}

		return discussion;
		
	}
	
	public boolean createDiscussion(User user, Discussion discussion, Topic topic) {
				
		 try {
			 
			 	PreparedStatement prepared = super.getConn()
		        		.prepareStatement("insert into DISCUSSION (id_creator,title,description,id_macro) values (?,?,?,?)");
		     	prepared.setInt(1,user.getId());
		        prepared.setString(2, discussion.getTitle());
		     	prepared.setString(3, discussion.getDescription());
		     	prepared.setInt(4,topic.getId());
		     	
		     	prepared.executeUpdate();
		     	System.out.println("Discussion create successfully(" + discussion.getTitle() + " | " + user.getName());
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

	
}
