package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import model.base.Category;
import model.base.CategoryImpl;

public class DBCategoryImpl extends DBManagerImpl implements Dao<CategoryImpl> {
	private ResultSet rs = null;
	private String query;
	private PreparedStatement prepared;


	@Override
	public List<CategoryImpl> getAll() {
		List<CategoryImpl> list = new ArrayList<>();
		query = "Select * from TOPIC";

		try {
			rs = open().executeQuery(query);
			while (rs.next()) {
				list.add(new CategoryImpl(rs.getInt("idMacro"), rs.getString("title")));
			}
			return list;
		} catch (Exception e) {
			System.out.println("Error while loading categories");
			return list;
		} finally {
			close();
		}
	}

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
			System.out.println("\nError while adding new discussion " + e);
			return false;
		} finally {
			close();
		}
	}

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
			System.out.println("\nError while adding new discussion " + e);
			return false;
		} finally {
			close();
		}
	}

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
			System.out.println("\nError while adding new discussion " + e);
			return false;
		} finally {
			close();
		}
	}
}