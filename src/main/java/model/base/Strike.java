package model.base;

/**
*This class implements the methods for the strike.
*/
public class Strike {

	private Integer idUser;
	private Integer strike;

	public Strike(final Integer idUser, final Integer strike) {
		this.idUser = idUser;
		this.strike = strike;
	}

	public final Integer getIdUser() {
		return idUser;
	}

	public final Integer getStrike() {
		return strike;
	}

}
