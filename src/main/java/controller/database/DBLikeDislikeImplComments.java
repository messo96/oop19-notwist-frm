package controller.database;

import java.util.Optional;

import model.base.LikeSet;
import model.database.DBLikeDislike;

public class DBLikeDislikeImplComments implements IDBLikeDislike {
	private DBLikeDislike dbl = new DBLikeDislike();

	public Integer getLikes(final Integer idComment) {
		return (int) dbl.read().stream().filter(l -> l.getIdComment().get() == idComment && l.getLike()).count();
	}

	public Integer getDislikes(final Integer idComment) {
		return (int) dbl.read().stream().filter(l -> l.getIdComment().get() == idComment && l.getDislike()).count();
	}

	public boolean setLike(final Integer idComment, final Integer idUser) {
		if (isStillLiked(idComment, idUser))
			return dbl.delete(this.getIdLikes(idComment, idUser));
		else if (isStillDisliked(idComment, idUser))
			return dbl.update(new LikeSet(getIdLikes(idComment, idUser), true, false, idUser, Optional.empty(), Optional.of(idComment)));
		else
			return dbl.create(new LikeSet(0, true, false, idUser, Optional.empty(), Optional.of(idComment)));
	}

	public boolean setDislike(final Integer idComment, final Integer idUser) {
		if (isStillDisliked(idComment, idUser))
			return dbl.delete(this.getIdLikes(idComment, idUser));
		else if (isStillLiked(idComment, idUser))
			return dbl.update(new LikeSet(getIdLikes(idComment, idUser), false, true, idUser, Optional.empty(), Optional.of(idComment)));
		else
			return dbl.create(new LikeSet(0, false, true, idUser, Optional.empty(), Optional.of(idComment)));
	}

	private boolean isStillLiked(final Integer idComment, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdComment().get() == idComment && l.getIdUser() == idUser && l.getLike())
				.iterator().hasNext();
	}

	private boolean isStillDisliked(final Integer idComment, final Integer idUser) {
		return dbl.read().stream()
				.filter(l -> l.getIdComment().get() == idComment && l.getIdUser() == idUser && l.getDislike())
				.iterator().hasNext();
	}

	private Integer getIdLikes(final Integer idComment, final Integer idUser) {
		return dbl.read().stream().filter(l -> l.getIdComment().get() == idComment && l.getIdUser() == idUser)
				.findFirst().get().getId();
	}

}
