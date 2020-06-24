package controller.database;

import java.util.List;
import java.util.Optional;

import model.base.Category;
import model.base.DiscussionImpl;

public interface IDiscussionImplDB {

	/**
	 * read all the discussion from database.
	 * 
	 * @return list of {@link DiscussionImpl}
	 */
	List<DiscussionImpl> getAll();

	/**
	 * Upload a new discussion.
	 * 
	 * @param idUser      id of the user that write the new discussion
	 * @param title       of the discussion
	 * @param description of the discussion
	 * @param category    where to identifier the discussion
	 * @return true if discussion created successfully, false otherwise
	 */
	boolean createDiscussion(Integer idUser, String title, String description, Category category);

	/**
	 * get a discussion from idDiscussion.
	 * 
	 * @param idDiscussion id of the discussion to get
	 * @return if exist Optional of {@link DiscussionImpl}, Optional empty otherwise
	 */
	Optional<DiscussionImpl> getDiscussion(Integer idDiscussion);

	/**
	 * get all the discussion filtered by title.
	 * 
	 * @param title or part of this that is contained in discussions
	 * @return if exists Optional of list of {@link DiscussionImpl}, Optional empty
	 *         otherwise
	 */
	Optional<List<DiscussionImpl>> getDiscussion(String title);

	/**
	 * get all the discussions identified from the category.
	 * 
	 * @param category to find discussions
	 * @return if exists Optional of list of {@link DiscussionImpl}, Optional empty
	 *         otherwise
	 */
	Optional<List<DiscussionImpl>> getDiscussion(Category category);

	/**
	 * get all the discussions write to the user.
	 * 
	 * @param idUser id of the user to search his/her discussion
	 * @return if exists Optional of list of {@link DiscussionImpl}, Optional empty
	 *         otherwise
	 */
	Optional<List<DiscussionImpl>> getDiscussions(Integer idUser);

	/**
	 * get discussions based on relation like/dislike.
	 * 
	 * @return if exists discussions Optional of list of {@link DiscussionImpl}
	 *         limited to {{@link #MAX_TOP}, Optional of empty otherwise
	 */
	Optional<List<DiscussionImpl>> getTopDiscussion();

	/**
	 * delete a discussion from database.
	 * 
	 * @param idDiscussion id of the discussion to remove
	 * @return true if discussion deleted successfully, false otherwise
	 */
	boolean remove(Integer idDiscussion);
}
