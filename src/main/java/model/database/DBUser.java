package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;
import java.util.List;

import model.Log;
import model.base.User;
import model.crypt.CrypterImplementation;

/**
 * Class for manage interaction with database from Users
 * 
 * @author Giovanni Messina
 */
public class DBUser extends DBManagerImpl implements Dao<User> {
	private Log log = Log.getInstance();
	private ResultSet rs = null;
	private PreparedStatement prepared;
	private String query;
	private CrypterImplementation crp = new CrypterImplementation();

	/**
	 * {@inheritDoc}
	 */
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
			log.logWarning("Error while read all users" + e);
			return list;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(User t) {
		try {
			open();
			prepared = super.getConn()
					.prepareStatement("insert into UTENTE (nome, password, email,isModeratore) values (?,?,?,?)");
			prepared.setString(1, t.getUsername());
			prepared.setString(2, crp.Crypt(t.getPassword()));
			prepared.setString(3, crp.Crypt(t.getEmail()));
			prepared.setBoolean(4, t.isModerator());

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("Error while adding new user " + e);
			return false;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(User t) {
		// TODO Auto-generated method stub
		return false;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(Integer id) {
		try {
			query = "delete from UTENTE where idUser = ?";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, id);

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("\nError while delete user(id=" + id + ")" + e);
			return false;
		} finally {
			close();
		}
	}

}
