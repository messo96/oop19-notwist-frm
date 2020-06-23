package model.base;

import java.util.Date;

public interface Discussion {
	
	/**
	 * 
	 * @return title of the discussion
	 */
	String getTitle();

	/**
	 * 
	 * @return description of the discussion
	 */
	String getDescription();

	/**
	 * 
	 * @return id of the user that create the discussion
	 */
	int getIdUser();

	/**
	 * 
	 * @return id of the discussion in database
	 */
	int getIdDiscussion();

	/**
	 * 
	 * @return data when discussion created
	 */
	Date getData();

	/**
	 * 
	 * @return {@link Category} of the discussion
	 */
	Category getCategory();

	@Override
	String toString();

}
