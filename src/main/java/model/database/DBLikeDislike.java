package model.database;


public interface DBLikeDislike{
	
	public boolean addLike(final Integer idDiscussion, final Integer idUser);
	
	public boolean addDislike(final Integer idDiscussion, final Integer idUser);
	
	public Integer getLike(final Integer idDiscussion);
	
	public Integer getDislike(final Integer idDiscussion);
	
	public boolean isStillLiked(final Integer idDiscussion, final Integer idUser);
	
	public boolean isStillDisliked(final Integer idDiscussion, final Integer idUser);
	
}
