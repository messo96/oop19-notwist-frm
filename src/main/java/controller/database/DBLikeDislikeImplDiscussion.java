package controller.database;

import java.util.Optional;

import model.base.LikeSet;
import model.database.DBLikeDislike;
import controller.database.IDBLikeDislike;

/**
 * Class that through {@link DBLikeDislike} connect view
 * @author Giovanni Messina
 *
 */
public class DBLikeDislikeImplDiscussion implements IDBLikeDislike {
	private DBLikeDislike dbl = new DBLikeDislike();

	/**
	 * {@inheritDoc}
	 */
	public Integer getLikes(final Integer idDiscussion) {
		return (int) dbl.read().stream().filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getLike()).count();
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer getDislikes(final Integer idDiscussion) {
		return (int) dbl.read().stream().filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getDislike())
				.count();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean setLike(final Integer idDiscussion, final Integer idUser) {
		if (isStillLiked(idDiscussion, idUser))
			return dbl.delete(this.getIdLikes(idDiscussion, idUser));
		else if (isStillDisliked(idDiscussion, idUser))
			return dbl.update(new LikeSet(getIdLikes(idDiscussion, idUser), true, false, idUser,
					Optional.of(idDiscussion), Optional.empty()));
		else
			return dbl.create(new LikeSet(0, true, false, idUser, Optional.of(idDiscussion), Optional.empty()));
	}


	/**
	 * {@inheritDoc}
	 */
	public boolean setDislike(final Integer idDiscussion, final Integer idUser) {
		if (isStillDisliked(idDiscussion, idUser))
			return dbl.delete(this.getIdLikes(idDiscussion, idUser));
		else if (isStillLiked(idDiscussion, idUser))
			return dbl.update(new LikeSet(getIdLikes(idDiscussion, idUser), false, true, idUser,
					Optional.of(idDiscussion), Optional.empty()));
		else
			return dbl.create(new LikeSet(0, false, true, idUser, Optional.of(idDiscussion), Optional.empty()));
	}

	//control if the discussion is still liked by that user, return true if it is still liked by that user, false if it is not
	private boolean isStillLiked(final Integer idDiscussion, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getIdUser() == idUser && l.getLike())
				.iterator().hasNext();
	}


	//control if the discussion is still disliked by that user, return true if it is still disliked by that user, false if it is not
	private boolean isStillDisliked(final Integer idDiscussion, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getIdUser() == idUser && l.getDislike())
				.iterator().hasNext();
	}

	// return the identifier of the tuple like/dislike, you can find that through
	// idDiscussion and idUser
	private Integer getIdLikes(final Integer idDiscussion, final Integer idUser) {
		return dbl.read().stream().filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getIdUser() == idUser)
				.findFirst().get().getId();
	}

}
