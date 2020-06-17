package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class DBStrikeImpl extends DBManagerImpl implements DBStrike {
	private String query;
	private ResultSet rs;
	private final Integer MAX_STRIKE = 3;

	@Override
	public Integer getStrikes(Integer idUser) {

		try {
			query = "select strike from UTENTE where idUser= " + idUser;
			rs = open().executeQuery(query);

			if (rs.next()) {
				return rs.getInt("strike");
			}

		} catch (SQLException e) {
			System.out.println("Error while download strike from idUser:" + idUser + "\n" + e);
		} finally {
			close();
		}
		return -1;
	}

	@Override
	public boolean setStrike(final Integer idUser, final Integer value) {
		try {
			open();
			PreparedStatement prepared = getConn()
					.prepareStatement("update UTENTE set strike = ? where idUser = ?");

			prepared.setInt(1, value);
			prepared.setInt(2, idUser);
			prepared.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Error while increment strike from idUser:" + idUser + "\n" + e);
			return false;
		}
		finally {
			close();
		}

	}

	@Override
	public boolean resetStrike(Integer idUser) {
		try {
			if (maxStrike(idUser)) {
				open();
				PreparedStatement prepared = getConn()
						.prepareStatement("update UTENTE set strike = 0 where idUser = ?");

				prepared.setInt(1, idUser);
				prepared.executeUpdate();
				return true;
			} else
				return false;
		} catch (SQLException e) {
			System.out.println("Error while increment strike from idUser:" + idUser + "\n" + e);
			return false;
		} finally {
			close();
		}
	}

	private boolean maxStrike(final Integer idUser) {
		try {
			query = "select strike from UTENTE where idUser= " + idUser;
			rs = open().executeQuery(query);

			if (rs.next() && rs.getInt("strike") >= MAX_STRIKE)
				return true;
			else
				return false;
		} catch (SQLException e) {
			System.out.println("Error while control if strike is max from idUser:" + idUser + "\n" + e);
			return false;
		} finally {
			close();
		}
	}

}