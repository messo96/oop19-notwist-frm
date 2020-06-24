package controller.database;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.base.Category;
import model.base.DiscussionImpl;
import model.database.DiscussionDB;

/**
 * Class that through model class {@link DiscussionDB} connect view.
 * 
 *
 */
public class DiscussionImplDB implements IDiscussionImplDB {
	
	private DiscussionDB dbd = new DiscussionDB();
	private LikeDislikeImplDiscussionDB dblike = new LikeDislikeImplDiscussionDB();
	private static final Integer MAX_TOP = 5;

	/**
	 * {@inheritDoc}
	 */
	public List<DiscussionImpl> getAll() {
		return dbd.read();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean createDiscussion(final Integer idUser, final String title, final String description,
			final Category category) {
		// number 0 in new DiscussionImpl is because i don't know the id of the new
		// discussion, and in create method idDiscussion isn't used
		return dbd.create(new DiscussionImpl(0, idUser, title, description, category, new Date()));
	}

	/**
	 * {@inheritDoc}
	 */
	public Optional<DiscussionImpl> getDiscussion(final Integer idDiscussion) {
		return dbd.read().stream().filter(d -> d.getIdDiscussion() == idDiscussion).findFirst();
	}


	/**
	 * {@inheritDoc}
	 */
	public Optional<List<DiscussionImpl>> getDiscussion(final String title) {
		return Optional.of(dbd.read().stream().filter(d -> d.getTitle().contains(title)).collect(Collectors.toList()));
	}


	/**
	 * {@inheritDoc}
	 */
	public Optional<List<DiscussionImpl>> getDiscussion(final Category category) {
		return Optional.of(dbd.read().stream().filter(d -> d.getCategory().getId().equals(category.getId()))
				.collect(Collectors.toList()));
	}


	/**
	 * {@inheritDoc}
	 */
	public Optional<List<DiscussionImpl>> getDiscussions(final Integer idUser) {
		return Optional.of(dbd.read().stream().filter(d -> d.getIdUser() == idUser).collect(Collectors.toList()));
	}


	/**
	 * {@inheritDoc}
	 */
	public Optional<List<DiscussionImpl>> getTopDiscussion() {
		return Optional.of(dbd.read().stream()
				.sorted((d1, d2) -> Integer.compare(
						dblike.getLikes(d2.getIdDiscussion()) - dblike.getDislikes(d2.getIdDiscussion()),
						dblike.getLikes(d1.getIdDiscussion()) - dblike.getDislikes(d1.getIdDiscussion())))
				.limit(MAX_TOP).collect(Collectors.toList()));
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean remove(final Integer idDiscussion) {
		return dbd.delete(idDiscussion);
	}

}
