package controller.database;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.database.CommentsDB;
import rombo.new_class.CommentsImplement;

/**
 * Class that through model class {@link CommentsDB} connect view.
 * 
 *
 */
public class CommentsImplDB {
	
	private CommentsDB dbc = new CommentsDB();

	/**
	 * Find all the comments in that discussion.
	 * 
	 * @param idDiscussion id of the discussion where to search relative comments
	 * @return Optional of list of {@linkCommentsImplement} if that discussion has
	 *         comments, Optional of empty otherwise
	 */
	public Optional<List<CommentsImplement>> getComments(final Integer idDiscussion) {
		return Optional.of(dbc.read().stream().filter(c -> c.GetIDDiscussion().get() == idDiscussion)
				.collect(Collectors.toList()));
	}

	/**
	 * Upload a new comment of a discussion in database.
	 * 
	 * @param idDiscussion id of the discussion where to comment
	 * @param idUser       id of the user that write the comment
	 * @param comment      one that user want to write as comment
	 * @return true if comment created successfully, false otherwise
	 */
	public boolean createComment(final Integer idDiscussion, final Integer idUser, final String comment) {
		return dbc.create(
				new CommentsImplement(idUser, comment, Optional.empty(), Optional.of(idDiscussion), new Date()));
	}

	/**
	 * Delete a comment from database.
	 * 
	 * @param idComment id of the comment to remove
	 * @return true if comment deleted successfully, false otherwise
	 */
	public boolean removeComment(final Integer idComment) {
		return dbc.delete(idComment);
	}
}
