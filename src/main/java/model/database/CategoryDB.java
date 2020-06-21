package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Log;
import model.base.CategoryImpl;

/**
 * Class for Category table based on DAO
 * 
 * @author Giovanni Messina
 *
 */
public class CategoryDB extends ManagerImplDB implements Dao<CategoryImpl> {
	private Log log = Log.getInstance();
	private ResultSet rs = null;
	private String query;
	private PreparedStatement prepared;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CategoryImpl> read() {
		List<CategoryImpl> list = new ArrayList<>();
		query = "Select * from TOPIC";

		try {
			rs = open().executeQuery(query);
			while (rs.next()) {
				list.add(new CategoryImpl(rs.getInt("idMacro"), rs.getString("title")));
			}
			return list;
		} catch (Exception e) {
			log.logWarning("Error while download categories " + e);
			return list;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(CategoryImpl t) {
		try {
			query = "insert into TOPIC (title) values (?)";
			open();
			PreparedStatement prepared = super.getConn().prepareStatement(query);
			prepared.setString(1, t.getName());
			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("Error while adding new discussion " + e);
			return false;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(CategoryImpl t) {
		try {
			query = "update TOPIC set title = (?) where idMacro = ?";
			open();
			PreparedStatement prepared = super.getConn().prepareStatement(query);
			prepared.setString(1, t.getName());
			prepared.setInt(2, t.getId());
			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("\nError while update a discussion(idDiscussion=" + t.getId() + ")" + e);
			return false;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(Integer id) {
		try {
			query = "delete from TOPIC where idMacro = ?";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, id);
			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("\nError while delete a discussion ( idDiscussion= " + id + ")" + e);
			return false;
		} finally {
			close();
		}
	}
}