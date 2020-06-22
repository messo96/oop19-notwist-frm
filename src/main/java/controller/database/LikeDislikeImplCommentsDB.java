package controller.database;

import java.util.Optional;

import model.base.LikeSet;
import model.database.LikeDislikeDB;

/**
 * Class that through {@link LikeDislikeDB} connect view.
 * 
 *
 */
public class LikeDislikeImplCommentsDB implements ILikeDislikeDB {
	
	private LikeDislikeDB dbl = new LikeDislikeDB();

	/**
	 * {@inheritDoc}
	 */

	public Integer getLikes(final Integer idComment) {
		return (int) dbl.read().stream().filter(l -> l.getIdComment().get() == idComment && l.getLike()).count();
	}

	/**
	 * {@inheritDoc}
	 */
	public Integer getDislikes(final Integer idComment) {
		return (int) dbl.read().stream().filter(l -> l.getIdComment().get() == idComment && l.getDislike()).count();
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean setLike(final Integer idComment, final Integer idUser) {
		if (isStillLiked(idComment, idUser)) {
			return dbl.delete(this.getIdLikes(idComment, idUser));
		} else if (isStillDisliked(idComment, idUser)) {
			return dbl.update(new LikeSet(getIdLikes(idComment, idUser), true, false, idUser, Optional.empty(),
					Optional.of(idComment)));
		} else {
			return dbl.create(new LikeSet(0, true, false, idUser, Optional.empty(), Optional.of(idComment)));
		}
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean setDislike(final Integer idComment, final Integer idUser) {
		if (isStillDisliked(idComment, idUser)) {
			return dbl.delete(this.getIdLikes(idComment, idUser));
		} else if (isStillLiked(idComment, idUser)) {
			return dbl.update(new LikeSet(getIdLikes(idComment, idUser), false, true, idUser, Optional.empty(),
					Optional.of(idComment)));
		} else {
			return dbl.create(new LikeSet(0, false, true, idUser, Optional.empty(), Optional.of(idComment)));
		}
	}

	// control if the comment is still liked by that user, return true if it is
	// still liked by that user, false if it is not
	private boolean isStillLiked(final Integer idComment, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdComment().get() == idComment && l.getIdUser() == idUser && l.getLike()).iterator()
				.hasNext();
	}

	// control if the comment is still disliked by that user, return true if it is
	// still disliked by that user, false if it is not
	private boolean isStillDisliked(final Integer idComment, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdComment().get() == idComment && l.getIdUser() == idUser && l.getDislike())
				.iterator().hasNext();
	}

	// return the identifier of the tuple like/dislike, you can find that through
	// idComment and idUser
	private Integer getIdLikes(final Integer idComment, final Integer idUser) {
		return dbl.read().stream().filter(l -> l.getIdComment().get() == idComment && l.getIdUser() == idUser)
				.findFirst().get().getId();
	}

}
