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
public class UserImplDB implements IUserImplDB {

	private UserDB dbu = new UserDB();

	/**
	 * 
	 * {@inheritDoc}
	 */
	public List<User> getAll() {
		return dbu.read();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Optional<User> getUser(final Integer idUser) {
		return dbu.read().stream().filter(u -> u.getId().equals(idUser)).findFirst();
	}

	/**
	 * 
	 * {@inheritDoc}
	 */
	public Optional<User> login(final String email, final String password) {
		return dbu.read().stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
				.findFirst();
	}

	/**
	 * 
	 * {@inheritDoc}
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
