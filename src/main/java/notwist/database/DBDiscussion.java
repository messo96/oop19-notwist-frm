package notwist.database;

import java.util.List;
import java.util.Optional;

import notwist.base.Category;
import notwist.base.Discussion;
import notwist.base.User;

public interface DBDiscussion {
	
	/**
	 * Search discussion/s of the user
	 * 
	 * @param idUser
	 * 			identifier of user that create the return discussion
	 * @return
	 * 			Optional empty if user hasn't create a discussion, Optional list of discussions otherwise
	 */
	public Optional< List<Discussion> >  getDiscussion(final User user);
	
	/**
	 * Create a new discussion and load on database
	 * 
	 * 
	 * @param discussion
	 * 			Discussion to load
	 * @param topic
	 * 			Category of the discussion
	 * @return
	 */
	public boolean createDiscussion(final Discussion discussion, final Category topic);
		
	/**
	 * 
	 * @return
	 * 		all the Discussion on database
	 */
	public Optional<List<Discussion>> getAllDiscussion();
	
	/**
	 * 
	 * @param title
	 * 			title to search in discussion
	 * @return
	 * 			all the discussion filter by that search
	 */		
	public Optional<List<Discussion>> getAllDiscussion(final String title);
	
	/**
	 * 
	 * @param category
	 * 			search discussion by category
	 * @return
	 * 			all the discussion filter by that search

	 */		
	public Optional<List<Discussion>> getAllDiscussion(final Category category);
	
	/**
	 * 
	 */
	public Optional<Discussion> getDiscussionFromTitle(final String title);


}
