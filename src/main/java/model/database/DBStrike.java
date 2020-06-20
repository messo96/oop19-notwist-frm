package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import model.Log;
import model.base.Strike;

public class DBStrike extends DBManagerImpl implements Dao<Strike> {
	private Log log = Log.getInstance();
	private String query;
	private ResultSet rs;

	@Override
	public List<Strike> read() {
		List<Strike> list = new LinkedList<>();

		try {
			query = "select idUser, strike from UTENTE";
			rs = open().executeQuery(query);

			while (rs.next()) {
				list.add(new Strike(rs.getInt("idUser"), rs.getInt("strike")));
			}
			return list;
		} catch (SQLException e) {
			log.logWarning("Error while download strikes " + e);
			return list;
		} finally {
			close();
		}
	}

	@Override
	public boolean create(Strike t) {
		// Automatic create a strike when create User (default strike = 0)
		return false;
	}

	@Override
	public boolean update(Strike t) {
		try {
			open();
			PreparedStatement prepared = getConn().prepareStatement("update UTENTE set strike = ? where idUser = ?");

			prepared.setInt(1, t.getStrike());
			prepared.setInt(2, t.getIdUser());
			prepared.executeUpdate();
			return true;
		} catch (SQLException e) {
			log.logWarning(
					"Error while increment strike (idUser:" + t.getIdUser() + "|strike=" + t.getStrike() + ")" + e);
			return false;
		} finally {
			close();
		}
	}

	@Override
	public boolean delete(Integer id) {
		return this.update(new Strike(id, 0));
	}

}