package model.database;

import java.util.List;

/**
 * Design pattern DatabaseAccessObject based on CRUD.
 *
 * @param <T>
 */
public interface Dao<T> {
	
	/**
	 * Read database table about T object.
	 * 
	 * @return List of T downloaded from the database
	 */
	List<T> read();

	/**
	 * Create new record in the database.
	 * 
	 * @param t object to upload
	 * @return True if created successfully, False otherwise
	 */
	boolean create(T t);

	/**
	 * Update existing record.
	 * 
	 * @param t object to upload
	 * @return True if uploaded successfully, False otherwise
	 */
	boolean update(T t);

	/**
	 * 
	 * @param id identifier that recognizes record in the database
	 * @return True if deleted succesfully, False otherwise
	 */
	boolean delete(Integer id);
}
