package controller.database;

/**
 * The interface is used to manage {@link LikeDislikeImplDiscussionDB} and
 * {@link LikeDislikeImplCommentsDB}.
 *
 * 
 */

public interface ILikeDislikeDB {

	/**
	 * get number of likes.
	 * 
	 * @param id of the corresponding object to identifier inside database
	 * @return number of likes
	 */
	Integer getLikes(Integer id);

	/**
	 * get number of dislikes.
	 * 
	 * @param id of the corresponding object to identifier inside database
	 * @return number of dislikes
	 */
	Integer getDislikes(Integer id);

	/**
	 * set a like .
	 * 
	 * @param id     of the corresponding object to identifier inside database
	 * @param idUser id of the user that want to set a like
	 * @return true if like is set, false otherwise
	 */
	boolean setLike(Integer id, Integer idUser);

	/**
	 * set a dislike.
	 * 
	 * @param id     of the corresponding object to identifier inside database
	 * @param idUser id of the user that want to set a dislike
	 * @return true if dislike is set, false otherwise
	 */
	boolean setDislike(Integer id, Integer idUser);

}
