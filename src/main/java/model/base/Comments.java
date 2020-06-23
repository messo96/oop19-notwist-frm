package model.base;

/*This interface extend "BaseAccount" that represent the base information of every users.*/

import java.util.Optional;

import rombo.discuss.BaseAccount;

public interface Comments extends BaseAccount {
	
	/* This method must return the comment. */
	String getComment();

	/*
	 * This optional method if possible return the topic where the comments is
	 * wrote.
	 */
	Optional<String> getTopic();

	/* this optional method if possible return the number of the comments. */
	Optional<Integer> getNumberOfCommet();
}
