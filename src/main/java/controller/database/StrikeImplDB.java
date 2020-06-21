package controller.database;

import model.base.Strike;
import model.database.StrikeDB;

/**
 * Class that through model class {@link StrikeDB} connect view
 * 
 * @author Giovanni Messina
 *
 */
public class StrikeImplDB {
	private StrikeDB dbs = new StrikeDB();

	/**
	 * get number of strikes of the user
	 * 
	 * @param idUser id of the user that wants to know number of strikes
	 * @return number of strikes
	 */
	public Integer getStrike(final Integer idUser) {
		return dbs.read().stream().filter(u -> u.getIdUser() == idUser).findFirst().get().getStrike();
	}

	/**
	 * set the strike to the user
	 * 
	 * @param idUser id of the user that want to strike
	 * @param value  number of strike to update
	 * @return true if set successfully, false otherwise
	 */
	public boolean setStrike(final Integer idUser, final Integer value) {
		return dbs.update(new Strike(idUser, value));
	}

	/**
	 * reset strike of the user
	 * @param idUser id of the user to reset strike
	 * @return true if reset completed successfully, false otherwise
	 */
	public boolean reset(final Integer idUser) {
		return dbs.delete(idUser);
	}
}
