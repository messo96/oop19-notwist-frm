package controller.database;

import model.base.Strike;
import model.database.DBStrike;

public class DBStrikeImpl extends DBStrike {

	public Integer getStrike(final Integer idUser) {
		return super.read().stream().filter(u -> u.getIdUser() == idUser).findFirst().get().getStrike();
	}

	public boolean setStrike(final Integer idUser, final Integer value) {
		return super.update(new Strike(idUser, value));
	}

	public boolean reset(final Integer idUser) {
		return super.delete(idUser);
	}
}
