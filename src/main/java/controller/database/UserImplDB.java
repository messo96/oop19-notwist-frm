package controller.database;

import java.util.List;
import java.util.Optional;

import model.base.User;
import model.database.UserDB;

/**
 * Class that through model class {@link UserDB} connect view.
 * 
 *
 */
public class UserImplDB {
	
	private UserDB dbu = new UserDB();

	/**
	 * get all users.
	 * 
	 * @return list of {@link User}
	 */
	public List<User> getAll() {
		return dbu.read();
	}

	/**
	 * get {@link User} from id.
	 * 
	 * @param idUser id of the user to find
	 * @return Optional of {@link User} if exist, false otherwise
	 */
	public Optional<User> getUser(final Integer idUser) {
		return dbu.read().stream().filter(u -> u.getId() == idUser).findFirst();
	}

	/**
	 * control if combination email-password correspond to a {@link User}.
	 * 
	 * @param email    of the user
	 * @param password of the user
	 * @return Optional of {@link User} if combination is correct, Optional empty
	 *         otherwise
	 */
	public Optional<User> login(final String email, final String password) {
		return dbu.read().stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
				.findFirst();
	}

	/**
	 * create new user.
	 * 
	 * @param username of the new user
	 * @param password of the new user
	 * @param email    of the new user
	 * @param isMod    boolean is moderator
	 * @return true if registered correctly, false otherwise
	 */
	public boolean register(final String username, final String password, final String email, final boolean isMod) {
		if (existUser(email)) {
			return false;
		}
		return dbu.create(new User(0, username, password, email, isMod));
	}

	// control if user still exist, true if exist
	private boolean existUser(final String email) {
		return dbu.read().stream().filter(u -> u.getEmail().equals(email)).findFirst().isPresent();
	}

}
