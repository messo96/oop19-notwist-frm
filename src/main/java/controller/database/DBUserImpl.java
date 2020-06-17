package controller.database;

import java.util.Optional;

import model.base.User;
import model.database.DBUser;

public class DBUserImpl extends DBUser {

	public Optional<User> getUser(final Integer idUser) {
		return super.read().stream().filter(u -> u.getId() == idUser).findFirst();
	}

	public Optional<User> login(final String email, final String password) {
		return super.read().stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
				.findFirst();
	}

	public boolean register(final String username, final String password, final String email, final boolean isMod) {
		return super.create(new User(0, username, password, email, isMod));
	}
	
	
}
