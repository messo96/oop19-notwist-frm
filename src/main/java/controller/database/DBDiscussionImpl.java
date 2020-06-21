package controller.database;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.base.Category;
import model.base.DiscussionImpl;
import model.database.DBDiscussion;
import model.database.DBLikeDislike;

/**
 * Class that through model class {@link DBDiscussion} connect view
 * 
 * @author Giovanni Messina
 *
 */
public class DBDiscussionImpl {
	private DBDiscussion dbd = new DBDiscussion();
	private DBLikeDislikeImplDiscussion dblike = new DBLikeDislikeImplDiscussion();
	private final Integer MAX_TOP = 5;

	/**
	 * read all the discussion from database
	 * 
	 * @return list of {@link DiscussionImpl}
	 */
	public List<DiscussionImpl> getAll() {
		return dbd.read();
	}

	/**
	 * Upload a new discussion
	 * 
	 * @param idUser      id of the user that write the new discussion
	 * @param title       of the discussion
	 * @param description of the discussion
	 * @param category    where to identifier the discussion
	 * @return true if discussion created successfully, false otherwise
	 */
	public boolean createDiscussion(final Integer idUser, final String title, final String description,
			final Category category) {
		// number 0 in new DiscussionImpl is because i don't know the id of the new
		// discussion, and in create method idDiscussion isn't used
		return dbd.create(new DiscussionImpl(0, idUser, title, description, category, new Date()));
	}

	/**
	 * get a discussion from idDiscussion
	 * 
	 * @param idDiscussion id of the discussion to get
	 * @return if exist Optional of {@link DiscussionImpl}, Optional empty otherwise
	 */
	public Optional<DiscussionImpl> getDiscussion(final Integer idDiscussion) {
		return dbd.read().stream().filter(d -> d.getIdDiscussion() == idDiscussion).findFirst();
	}

	/**
	 * get all the discussion filtered by title
	 * 
	 * @param title or part of this that is contained in discussions
	 * @return if exists Optional of list of {@link DiscussionImpl}, Optional empty
	 *         otherwise
	 */
	public Optional<List<DiscussionImpl>> getDiscussion(final String title) {
		return Optional.of(dbd.read().stream().filter(d -> d.getTitle().contains(title)).collect(Collectors.toList()));
	}

	/**
	 * get all the discussions identified from the category
	 * 
	 * @param category to find discussions
	 * @return if exists Optional of list of {@link DiscussionImpl}, Optional empty
	 *         otherwise
	 */
	public Optional<List<DiscussionImpl>> getDiscussion(final Category category) {
		return Optional.of(dbd.read().stream().filter(d -> d.getCategory().getId() == category.getId())
				.collect(Collectors.toList()));
	}

	/**
	 * get all the discussions write to the user
	 * 
	 * @param idUser id of the user to search his/her discussion
	 * @return if exists Optional of list of {@link DiscussionImpl}, Optional empty
	 *         otherwise
	 */
	public Optional<List<DiscussionImpl>> getDiscussions(final Integer idUser) {
		return Optional.of(dbd.read().stream().filter(d -> d.getIdUser() == idUser).collect(Collectors.toList()));
	}

	/**
	 * get discussions based on relation like/dislike
	 * 
	 * @return if exists discussions Optional of list of {@link DiscussionImpl}
	 *         limited to {{@link #MAX_TOP}, Optional of empty otherwise
	 */
	public Optional<List<DiscussionImpl>> getTopDiscussion() {
		return Optional.of(dbd.read().stream()
				.sorted((d1, d2) -> Integer.compare(
						dblike.getLikes(d1.getIdDiscussion()) - dblike.getDislikes(d1.getIdDiscussion()),
						dblike.getLikes(d2.getIdDiscussion() - dblike.getDislikes(d2.getIdDiscussion()))))
				.limit(MAX_TOP).collect(Collectors.toList()));
	}

	/**
	 * delete a discussion from database
	 * 
	 * @param idDiscussion id of the discussion to remove
	 * @return true if discussion deleted successfully, false otherwise
	 */
	public boolean remove(final Integer idDiscussion) {
		return dbd.delete(idDiscussion);
	}

}
