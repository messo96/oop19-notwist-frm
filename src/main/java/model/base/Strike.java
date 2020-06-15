package model.base;

public class Strike {
	private Integer idUser;
	private Integer strike;

	public Strike(Integer idUser, Integer strike) {
		this.idUser = idUser;
		this.strike = strike;
	}

	public Integer getIdUser() {
		return idUser;
	}

	public Integer getStrike() {
		return strike;
	}

}
