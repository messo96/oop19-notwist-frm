package notwist.database;

import java.util.List;
import java.util.Optional;

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
	 * @param user
	 * 			Creator of the discussion
	 * @param discussion
	 * 			Discussion to load
	 * @param topic
	 * 			Category of the discussion
	 * @return
	 */
	public boolean createDiscussion(final User user, final Discussion discussion, final Category topic);
		
	public Optional<List<Discussion>> getAllDiscussion();

}
