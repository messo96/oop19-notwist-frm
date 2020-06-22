package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
//				list.add(new Report("idUser, idDiscussion, description, pending(bool)");
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
		try {
			query = "insert into REPORT (idUser, idDiscussion, description) values (?,?,?,?)";
			open();
			PreparedStatement prepared = super.getConn().prepareStatement(query);
//			prepared.setInt(1, t);
//			prepared.setInt(2, t);
//			prepared.setString(3, t);
//			prepared.setBoolean(4, t);

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("Error while create new discussion " + e);
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
