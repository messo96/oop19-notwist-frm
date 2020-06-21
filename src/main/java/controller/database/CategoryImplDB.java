package controller.database;

import java.util.List;
import java.util.Optional;

import model.base.CategoryImpl;
import model.database.CategoryDB;

/**
 * Class that through model class {@link CategoryDB} connects view
 * 
 * @author Giovanni Messina
 *
 */
public class CategoryImplDB {
	private CategoryDB dbc = new CategoryDB();

	/**
	 * read all the category present on database
	 * 
	 * @return List of {@link CategoryImpl}
	 */
	public List<CategoryImpl> getAll() {
		return dbc.read();
	}

	/**
	 * Try to find a category by name
	 * 
	 * @param name name of the category to search
	 * @return Optional of {@link CategoryImpl} if found, Optional of empty
	 *         otherwise
	 */
	public Optional<CategoryImpl> getCategory(final String name) {
		return dbc.read().stream().filter(c -> c.getName().equals(name)).findFirst();
	}

	/**
	 * Try to find a category by id
	 * 
	 * @param idCategory id of the category to search
	 * @return Optional of {@link CategoryImpl} if found, Optional of empty
	 *         otherwise
	 */
	public Optional<CategoryImpl> getCategory(final Integer idCategory) {
		return dbc.read().stream().filter(c -> c.getId() == idCategory).findFirst();
	}

}
