package controller.database;

import java.util.Optional;

import model.base.LikeSet;
import model.database.DBLikeDislike;
import controller.database.IDBLikeDislike;

public class DBLikeDislikeImplDiscussion implements IDBLikeDislike {
	private DBLikeDislike dbl = new DBLikeDislike();

	public Integer getLikes(final Integer idDiscussion) {
		return (int) dbl.read().stream().filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getLike()).count();
	}

	public Integer getDislikes(final Integer idDiscussion) {
		return (int) dbl.read().stream().filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getDislike())
				.count();
	}

	public boolean setLike(final Integer idDiscussion, final Integer idUser) {
		if (isStillLiked(idDiscussion, idUser))
			return dbl.delete(this.getIdLikes(idDiscussion, idUser));
		else if (isStillDisliked(idDiscussion, idUser))
			return dbl.update(new LikeSet(getIdLikes(idDiscussion, idUser), true, false, idUser, Optional.of(idDiscussion), Optional.empty()));
		else
			return dbl.create(new LikeSet(0, true, false, idUser, Optional.of(idDiscussion), Optional.empty()));
	}

	public boolean setDislike(final Integer idDiscussion, final Integer idUser) {
		if (isStillDisliked(idDiscussion, idUser))
			return dbl.delete(this.getIdLikes(idDiscussion, idUser));
		else if (isStillLiked(idDiscussion, idUser))
			return dbl.update(new LikeSet(getIdLikes(idDiscussion, idUser), false, true, idUser,
					Optional.of(idDiscussion), Optional.empty()));
		else
			return dbl.create(new LikeSet(0, false, true, idUser, Optional.of(idDiscussion), Optional.empty()));
	}

	private boolean isStillLiked(final Integer idDiscussion, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getIdUser() == idUser && l.getLike())
				.iterator().hasNext();
	}

	private boolean isStillDisliked(final Integer idDiscussion, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getIdUser() == idUser && l.getDislike())
				.iterator().hasNext();
	}

	private Integer getIdLikes(final Integer idDiscussion, final Integer idUser) {
		return dbl.read().stream().filter(l -> l.getIdDiscussion().get() == idDiscussion && l.getIdUser() == idUser)
				.findFirst().get().getId();
	}

}
