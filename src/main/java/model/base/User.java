package model.base;

/*
 * Methods for the user.
 */
public class User {
	
	private Integer id;
	private String username;
	private String password;
	private String email;
	private boolean isModerator;

	public User(final Integer id, final String username, final String password, final String email,
			final boolean isMod) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.email = email;
		this.isModerator = isMod;
	}

	public final Integer getId() {
		return id;
	}

	public final String getUsername() {
		return username;
	}

	public final String getPassword() {
		return password;
	}

	public final String getEmail() {
		return email;
	}

	public final boolean isModerator() {
		return isModerator;
	}

	public final String toString() {
		return this.getUsername() + " (" + this.getId() + ")\n" + "Email: " + getEmail() + "\tPassword: "
				+ getPassword() + "\tIsMod: " + isModerator();
	}

}
