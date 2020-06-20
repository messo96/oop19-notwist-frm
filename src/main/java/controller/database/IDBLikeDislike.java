package controller.database;

;

public interface IDBLikeDislike {

	public Integer getLikes(final Integer id);

	public Integer getDislikes(final Integer id);

	public boolean setLike(final Integer id, final Integer idUser);

	public boolean setDislike(final Integer id, final Integer idUser);


}
