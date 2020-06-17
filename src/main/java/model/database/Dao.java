package model.database;

import java.util.List;


//Design pattern DatabaseAccessObject
public interface Dao<T> {

	List<T> read();
	
	boolean create(final T t);
	
	boolean update(final T t);
	
	boolean delete(final Integer id);
}
