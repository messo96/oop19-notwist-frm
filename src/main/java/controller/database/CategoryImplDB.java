package controller.database;

import java.util.List;
import java.util.Optional;

import model.base.CategoryImpl;
import model.database.CategoryDB;

/**
 * Class that through model class {@link CategoryDB} connects view.
 * 
 *
 */
public class CategoryImplDB {
	
	private CategoryDB dbc = new CategoryDB();
	private List<CategoryImpl> list = dbc.read();
	/**
	 * read all the category present on database.
	 * 
	 * @return List of {@link CategoryImpl}
	 */
	public List<CategoryImpl> getAll() {
		return list;
	}

	/**
	 * Try to find a category by name.
	 * 
	 * @param name name of the category to search
	 * @return Optional of {@link CategoryImpl} if found, Optional of empty
	 *         otherwise
	 */
	public Optional<CategoryImpl> getCategory(final String name) {
		return list.stream().filter(c -> c.getName().equals(name)).findFirst();
	}

	/**
	 * Try to find a category by id.
	 * 
	 * @param idCategory id of the category to search
	 * @return Optional of {@link CategoryImpl} if found, Optional of empty
	 *         otherwise
	 */
	public Optional<CategoryImpl> getCategory(final Integer idCategory) {
		return list.stream().filter(c -> c.getId() == idCategory).findFirst();
	}

}
