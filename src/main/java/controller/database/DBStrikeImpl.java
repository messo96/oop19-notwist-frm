package controller.database;

import model.base.Strike;
import model.database.DBStrike;

public class DBStrikeImpl {
	private DBStrike dbs = new DBStrike();

	public Integer getStrike(final Integer idUser) {
		return dbs.read().stream().filter(u -> u.getIdUser() == idUser).findFirst().get().getStrike();
	}

	public boolean setStrike(final Integer idUser, final Integer value) {
		return dbs.update(new Strike(idUser, value));
	}

	public boolean reset(final Integer idUser) {
		return dbs.delete(idUser);
	}
}
