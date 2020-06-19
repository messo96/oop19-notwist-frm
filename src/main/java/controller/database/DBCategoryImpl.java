package controller.database;

import java.util.List;
import java.util.Optional;

import model.base.CategoryImpl;
import model.database.DBCategory;

public class DBCategoryImpl {
	private DBCategory dbc = new DBCategory();

	public List<CategoryImpl> getAll() {
		return dbc.read();
	}

	public Optional<CategoryImpl> getCategory(final String name) {
		return dbc.read().stream().filter(c -> c.getName().equals(name)).findFirst();
	}

	public Optional<CategoryImpl> getCategory(final Integer idCategory) {
		return dbc.read().stream().filter(c -> c.getId() == idCategory).findFirst();
	}

}
