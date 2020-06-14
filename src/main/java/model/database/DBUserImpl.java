package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import model.base.User;
import model.crypt.CrypterImplementation;

/**
 * Class for manage interaction with database from Users
 */
public class DBUserImpl extends DBManagerImpl implements DBUser {

	private ResultSet rs = null;
	private String query;
	private CrypterImplementation crp = new CrypterImplementation();
	
	// cambiare ed ottimizzare query con Relax
	public boolean existUser(final String email) {

		try {
			String query = "select * from UTENTE where email= '" + crp.Crypt(email) + "'";
			rs = open().executeQuery(query);
			return rs.next() ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			close();
		}
	}

	public boolean register(final String user, final String password, final String email, final boolean isModerator) {
		if (existUser(email)) {
			//JOptionPane.showMessageDialog(null, "Is still registered with this email \nUser: " + user);
			return false;
		}

		try {
			open();
			PreparedStatement prepared = super.getConn()
					.prepareStatement("insert into UTENTE (nome, password, email,isModeratore) values (?,?,?,?)");
			prepared.setString(1, user);
			prepared.setString(2, crp.Crypt(password));
			prepared.setString(3, crp.Crypt(email));
			prepared.setBoolean(4, isModerator);

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("\nError while adding new user " + e);
			return false;
		} finally {
			close();
		}
	}

	// cambiare ed ottimizzare query con Relax
	public Optional<User> login(final String email, final String password) {

		User user = null;
		try {
			query = "select * from UTENTE where email= '" + crp.Crypt(email) + "'";
			rs = open().executeQuery(query);
			if (rs.next() && rs.getString("email").contentEquals(crp.Crypt(email))
					&& rs.getString("password").contentEquals(crp.Crypt(password))) {
				user = new User(rs.getInt("idUser"), rs.getString("nome"), crp.Decrypt(rs.getString("password")),
						crp.Decrypt(rs.getString("email")), rs.getBoolean("isModeratore"));
				return Optional.of(user);
			}
			return Optional.empty();

		} catch (Exception e) {
			System.out.println("User doesn't exist! \n" + e);
			return Optional.empty();
		} finally {
			close();
		}

	}

	@Override
	public Optional<User> getUserFromId(Integer id) {
		User user = null;

		try {
			query = "SELECT * FROM UTENTE WHERE idUser=" + id;
			rs = open().executeQuery(query);
			if (rs.next())
				user = new User(rs.getInt("idUser"), rs.getString("nome"), crp.Decrypt(rs.getString("password")),
						crp.Decrypt(rs.getString("email")), rs.getBoolean("isModeratore"));

		} catch (Exception e) {
			System.out.println("Error while get User from Id\n" + e);
		} finally {
			close();
		}
		if (user != null)
			return Optional.of(user);
		else
			return Optional.empty();
	}

	@Override
	public List<User> getAllUsers() {
		List<User> list = new LinkedList<>();
		
		try {
			String query = "select * from UTENTE ";
			rs = open().executeQuery(query);
			while (rs.next())
				list.add(new User(rs.getInt("idUser"), rs.getString("nome"), crp.Decrypt(rs.getString("password")),
						crp.Decrypt(rs.getString("email")), rs.getBoolean("isModeratore")));
			return list;
		} catch (Exception e) {
			System.out.println("User doesn't exist!" + e);
			return list;
		} finally {
			close();
		}

	}

}
