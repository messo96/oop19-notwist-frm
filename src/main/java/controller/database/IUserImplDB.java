package controller.database;

import java.util.List;
import java.util.Optional;

import model.base.User;

public interface IUserImplDB {

	/**
	 * get all users.
	 * 
	 * @return list of {@link User}
	 */
	List<User> getAll();

	/**
	 * get {@link User} from id.
	 * 
	 * @param idUser id of the user to find
	 * @return Optional of {@link User} if exist, false otherwise
	 */
	Optional<User> getUser(Integer idUser);

	/**
	 * control if combination email-password correspond to a {@link User}.
	 * 
	 * @param email    of the user
	 * @param password of the user
	 * @return Optional of {@link User} if combination is correct, Optional empty
	 *         otherwise
	 */
	Optional<User> login(String email, String password);

	/**
	 * create new user.
	 * 
	 * @param username of the new user
	 * @param password of the new user
	 * @param email    of the new user
	 * @param isMod    boolean is moderator
	 * @return true if registered correctly, false otherwise
	 */
	boolean register(String username, String password, String email, boolean isMod);

}
