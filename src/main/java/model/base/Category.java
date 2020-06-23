package model.base;

/**
 * Category (or topic) when there are all the categories that tag various discussion.
 *
 */
public interface Category {
	
	/**
	 * 
	 * @return id of category.
	 */
	 Integer getId();
	
	/**
	 * 
	 * @return name of the category
	 */
	 String getName();
}
