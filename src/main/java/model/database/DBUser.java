package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.base.User;
import model.crypt.CrypterImplementation;

/**
 * Class for manage interaction with database from Users
 */
public class DBUser extends DBManagerImpl implements Dao<User> {

	private ResultSet rs = null;
	private String query;
	private CrypterImplementation crp = new CrypterImplementation();



	@Override
	public List<User> read() {
		List<User> list = new LinkedList<>();

		try {
			query = "select * from UTENTE ";
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

	@Override
	public boolean create(User t) {
		if (existUser(t.getEmail()))
			return false;

		try {
			open();
			PreparedStatement prepared = super.getConn()
					.prepareStatement("insert into UTENTE (nome, password, email,isModeratore) values (?,?,?,?)");
			prepared.setString(1, t.getUsername());
			prepared.setString(2, crp.Crypt(t.getPassword()));
			prepared.setString(3, crp.Crypt(t.getEmail()));
			prepared.setBoolean(4, t.isModerator());

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("\nError while adding new user " + e);
			return false;
		} finally {
			close();
		}
	}

	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean existUser(final String email) {

		try {
			query = "select * from UTENTE where email= '" + crp.Crypt(email) + "'";
			rs = open().executeQuery(query);
			return rs.next() ? true : false;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		} finally {
			close();
		}
	}

}
