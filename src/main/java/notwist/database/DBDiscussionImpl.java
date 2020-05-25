package notwist.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import notwist.base.Category;
import notwist.base.Discussion;
import notwist.base.DiscussionImpl;
import notwist.base.User;

public class DBDiscussionImpl extends DBManagerImpl implements DBDiscussion{

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date d;
	private ResultSet rs = null;
    private String query;
	
    
	public Optional<List<Discussion>> getDiscussion(final User user){
		List<Discussion> discussion = new LinkedList<>();
		
		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);
		 
	              
	     while (rs.next()) {
	    	 if(rs.getInt("idUser") == (user.getId()))
	       	discussion.add(new DiscussionImpl(rs.getInt("idDiscussion"), rs.getInt("idUser"),rs.getString("title"), 
					rs.getString("description"), new DBCategory().getCategoryById(rs.getInt("idMacro")), rs.getDate("data")));
	     }
		}
	     catch(SQLException e) {
	    	 System.out.println("Error while download discussion of " + user.toString() + "\n"+e);
	     }
		finally {
			close();
		}
			return Optional.of(discussion);
	}
	
	public boolean createDiscussion(final Discussion discussion, final Category topic) {			
		 try {
			 System.out.println(discussion);
			 System.out.println(topic.getName());
			 d = new Date();
			 query = "insert into Discussion (idUser, title, description, idMacro,data) values (?,?,?,?,?)";
			 	open();
			 	PreparedStatement prepared = super.getConn().prepareStatement(query);
		     	prepared.setInt(1,discussion.getIdUser());
		        prepared.setString(2, discussion.getTitle());
		     	prepared.setString(3, discussion.getDescription());
		     	prepared.setInt(4,topic.getId());
		     	prepared.setDate(5, java.sql.Date.valueOf(sdf.format(d)));

		     	
		     	prepared.executeUpdate();
		     	System.out.println("Discussion create successfully(" + discussion.getTitle() + " | " + 
		     													new DBUserImpl().getUserFromId(discussion.getIdUser()));
		     	return true;
		}
		catch(Exception e) {
			System.out.println("\nError while adding new discussion " + e);
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
	    		discussion.add(new DiscussionImpl(rs.getInt("idDiscussion"),rs.getInt("idUser"),rs.getString("title"), 
	    										rs.getString("description"), new DBCategory().getCategoryById(rs.getInt("idMacro")), rs.getDate("data")));
	     }
		}
	     catch(SQLException e) {
	    	 System.out.println("Error while download discussion"+e);
	     }
		finally {
			close();
		}
		
		return Optional.of(discussion);
	}

	@Override
	public Optional<List<Discussion>> getAllDiscussion(final String title) {
		List<Discussion> list = new ArrayList<>();
		list.addAll(this.getAllDiscussion().get().stream().filter(c -> c.getTitle()
											.toLowerCase().contains(title.toLowerCase())).collect(Collectors.toList()));		
		return Optional.of(list);
	}

	@Override
	public Optional<List<Discussion>> getAllDiscussion(Category category) {
		List<Discussion> list = new ArrayList<>();
		list.addAll(this.getAllDiscussion().get().stream().
								filter(c -> c.getCategory().getId() == category.getId()).collect(Collectors.toList()));
		
		return Optional.of(list);
	}

	@Override
	public Optional<Discussion> getDiscussionFromTitle(String title) {
		Discussion discussion = null;
		
		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);
		 
	              
	   while(rs.next()) {
		   if(rs.getString("title").contains(title))
	    		discussion = new DiscussionImpl(rs.getInt("idDiscussion"),rs.getInt("idUser"),rs.getString("title"), 
	    										rs.getString("description"), new DBCategory().getCategoryById(rs.getInt("idMacro")), rs.getDate("data"));
	     }
		}
	     catch(SQLException e) {
	    	 System.out.println("Error while download discussion"+e);
	     }
		finally {
			close();
		}
		
		return Optional.of(discussion);
	}

	
	
}
