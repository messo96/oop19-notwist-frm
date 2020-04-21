package notwist.database;

import java.util.Optional;

public interface DBUser {

	 /**
		 * 
		 * @param user
		 * 			verify that user effectively is registered
		 * @return
		 * 			true if it is registered, false otherwise
		 */
	public boolean existUser(final String email);
	
	/**
	 * 
	 * @param user
	 * 				name of the account
	 * @param password
	 *				encrypted password
	 * @param email
	 * 				an encrypted email
	 * @param isModerator
	 * 				True if the account has the privileges of moderator, false if it's a basic user
	 * @return
	 * 			true if account has been saved successfully, false otherwise
	 */
	public boolean register(final String user, final String password, final String email, final boolean isModerator);
	
	
	/**
	 * 
	 * @param email
	 * 			
	 * @param password
	 * 		
	 * @return
	 * 			Optional User correctly initialized if credential are corrected, Optional empty otherwise
	 */
	public Optional<User> login(final String email, final String password);
}
