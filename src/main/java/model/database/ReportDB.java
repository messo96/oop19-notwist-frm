package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.Log;
import model.base.Report;

public class ReportDB extends ManagerImplDB implements Dao<Report> {

	private Log log = Log.getInstance();
	private String query;
	private PreparedStatement prepared;
	private ResultSet rs;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Report> read() {
		List<Report> list = new ArrayList<>();
		query = "Select * from REPORT";
		try {
			rs = open().executeQuery(query);
			while (rs.next()) {
				list.add(new Report(rs.getInt("idReport"), Optional.of(rs.getInt("idDiscussion")),
						Optional.of(rs.getInt("idComment")), rs.getInt("idUser"), rs.getString("description"),
						rs.getBoolean("pending")));
			}
			return list;
		} catch (Exception e) {
			log.logWarning("Error while download all reports");
			return list;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(final Report t) {
		open();
		try {
			if (t.getIdComment().isEmpty()) {
				query = "insert into REPORT (idUser, idDiscussion, description) values (?,?,?)";
				PreparedStatement prepared = super.getConn().prepareStatement(query);
				prepared.setInt(1, t.getIdUser());
				prepared.setInt(2, t.getIdDiscuss().get());
				prepared.setString(3, t.getDescrtiption());
			} else {
				query = "insert into REPORT (idUser, idDiscussion, idComment, description) values (?,?,?)";
				PreparedStatement prepared = super.getConn().prepareStatement(query);
				prepared.setInt(1, t.getIdUser());
				prepared.setInt(2, t.getIdDiscuss().get());
				prepared.setInt(3, t.getIdComment().get());
				prepared.setString(4, t.getDescrtiption());
			}

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("Error while create new report " + e);
			return false;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(final Report t) {
		try {
			query = "update REPORT set pending = ? where idReport = ?";
			open();
			PreparedStatement prepared = super.getConn().prepareStatement(query);
			prepared.setBoolean(1, true);
//			prepared.setInt(2, t.getId());
			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("\nError while update report (idReport="/* +idReport */ + ")" + e);
			return false;
		} finally {
			close();
		}
	}

	@Override
	public final boolean delete(final Integer id) {
		try {
			open();
			query = "delete from REPORT where idReport= ?";
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, id);
			prepared.executeUpdate();
			return true;
		} catch (SQLException e) {
			log.logWarning("Error while delete report(idReport" + id + ")" + e);
			return false;
		} finally {
			close();
		}
	}

}
