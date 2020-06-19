package controller.database;

import java.util.List;
import java.util.Optional;

import model.base.User;
import model.database.DBUser;

public class DBUserImpl {
	private DBUser dbu = new DBUser();
	
	public List<User> getAll(){
		return dbu.read();
	}
	
	public Optional<User> getUser(final Integer idUser) {
		return dbu.read().stream().filter(u -> u.getId() == idUser).findFirst();
	}

	public Optional<User> login(final String email, final String password) {
		return dbu.read().stream().filter(u -> u.getEmail().equals(email) && u.getPassword().equals(password))
				.findFirst();
	}

	public boolean register(final String username, final String password, final String email, final boolean isMod) {
		if(existUser(email))
			return false;
		return dbu.create(new User(0, username, password, email, isMod));
	}
	
	public boolean existUser(final String email) {
		return dbu.read().stream().filter(u -> u.getEmail().equals(email)).findFirst().isPresent();
	}
	
	
}
