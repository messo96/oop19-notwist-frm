package rombo.discuss;

import java.util.Optional;

public class BaseAccountImplements implements BaseAccount {

	/* Fields. */
	private final int iD;
	private Optional<String> userName;

	/* Builder. */
	public BaseAccountImplements(final int iD, final Optional<String> userName) {
		this.iD = iD;
		this.userName = userName;
	}

	/* Get methods. */

	/* @Return the ID of the user. */
	public final int getID() {
		return this.iD;
	}

	/*
	 * @Retunr a Optional abought the username of the user, if the user is not
	 * anonymous return the username, else return an Optional.Empty
	 */
	public final Optional<String> getUserName() {
		if (this.userName != null) {
			return this.userName;
		} else {
			return Optional.empty();
		}
	}

}
