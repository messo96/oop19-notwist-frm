package model.database;

public interface DBStrike {

	/**
	 * 
	 * @param idUser id of the user to get Strikes
	 * @return
	 * 			number of strikes
	 */
	public Integer getStrikes(final Integer idUser);
	
	/**
	 * 
	 * @param idUser id of the user to change own strikes
	 * @return
	 * 			True if the change completely successfully, false otherwise
	 */
	public boolean setStrike(final Integer idUser, final Integer value);
	
	
	/**
	 * 
	 * @param idUser 
	 * @return
	 * 			True if Strike is equal to 3 and can reset, false if not equal and then cannot reset Strike
	 */
	public boolean resetStrike(final Integer idUser);


	
}
