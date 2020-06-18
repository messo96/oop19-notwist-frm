package controller.database;

import java.util.Optional;

import model.base.CategoryImpl;
import model.database.DBCategory;

public class DBCategoryImpl extends DBCategory {

	public Optional<CategoryImpl> getCategory(final String name) {
		return super.read().stream().filter(c -> c.getName().equals(name)).findFirst();
	}

	public Optional<CategoryImpl> getCategory(final Integer idCategory) {
		return super.read().stream().filter(c -> c.getId() == idCategory).findFirst();
	}

}
