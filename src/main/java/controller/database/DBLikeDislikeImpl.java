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
	
	public boolean setLike(final Integer idDiscussion, final Integer idUser){
		return super.create(new LikeSet(true, false, idUser, idDiscussion));
	}
	
	public boolean setDislike(final Integer idDiscussion, final Integer idUser){
		return super.create(new LikeSet(false, true, idUser, idDiscussion));
	}
	
}
