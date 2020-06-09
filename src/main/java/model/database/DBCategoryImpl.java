package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.swing.JOptionPane;

import model.base.Category;
import model.base.CategoryImpl;

public class DBCategoryImpl extends DBManagerImpl implements DBCategory {
	private ResultSet rs = null;
	private String query;

	public Optional<List<Category>> getCategories() {
		List<Category> list = new ArrayList<>();
		query = "Select * from TOPIC";

		try {
			rs = open().executeQuery(query);
			while (rs.next()) {
				list.add(new CategoryImpl(rs.getInt("idMacro"), rs.getString("title")));
			}

		} catch (Exception e) {
			System.out.println("Error while loading categories");
		} finally {
			close();
		}
		return Optional.of(list);
	}

	public boolean existCategory(String name) {
		query = "Select * from TOPIC";
		boolean flag = false;
		try {
			rs = open().executeQuery(query);
			while (rs.next()) {
				if (rs.getString("title").contentEquals(name)) {
					flag = true;
					break;
				}

			}
		} catch (Exception e) {
			System.out.println("Error looking for category " + name);
		} finally {
			close();
		}
		return flag;
	}

	/**
	 * NON mi piace ma è per far vedere nella lista della HomePage
	 * 
	 * @return
	 */
	

	public Category getCategoryByName(final String name) {
		return this.getCategories().get().stream().filter(c -> c.getName().equals(name)).findFirst().get();
	}

	public Category getCategoryById(final Integer id) {
		return this.getCategories().get().stream().filter(c -> c.getId() == id).findFirst().get();
	}

	@Override
	public boolean addCategory(String newCat) {
		try {
			query = "insert into TOPIC (title) values (?)";
			open();
			PreparedStatement prepared = super.getConn().prepareStatement(query);
			prepared.setString(1, newCat);
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