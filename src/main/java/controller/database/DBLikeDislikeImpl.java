package controller.database;

import model.base.LikeSet;
import model.database.DBLikeDislike;

public class DBLikeDislikeImpl extends DBLikeDislike {

	public Integer getLikes(final Integer idDiscussion) {
		return (int) super.read().stream().filter(l -> l.getIdDiscussion() == idDiscussion && l.getLike()).count();
	}

	public Integer getDislikes(final Integer idDiscussion) {
		return (int) super.read().stream().filter(l -> l.getIdDiscussion() == idDiscussion && l.getDislike()).count();
	}

	public boolean setLike(final Integer idDiscussion, final Integer idUser) {
		if (isStillLiked(idDiscussion, idUser))
			return false;
		else if ( isStillDisliked(idDiscussion, idUser))
			return update(new LikeSet(0, true, false, idUser, idDiscussion));
		else
			return create(new LikeSet(0, true, false, idUser, idDiscussion));
	}

	public boolean setDislike(final Integer idDiscussion, final Integer idUser) {
		if (isStillDisliked(idDiscussion, idUser))
			return false;
		else if (isStillLiked(idDiscussion, idUser))
			return update(new LikeSet(0, false, true, idUser, idDiscussion));
		else
			return create(new LikeSet(0, false, true, idUser, idDiscussion));
	}

	private boolean isStillLiked(final Integer idDiscussion, final Integer idUser) {
		return super.read().stream()
				.filter(l -> l.getIdDiscussion() == idDiscussion && l.getIdUser() == idUser && l.getLike()).iterator().hasNext();
	}

	private boolean isStillDisliked(final Integer idDiscussion, final Integer idUser) {
		return super.read().stream()
				.filter(l -> l.getIdDiscussion() == idDiscussion && l.getIdUser() == idUser && l.getDislike())
				.iterator().hasNext();
	}
}
