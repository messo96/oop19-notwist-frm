package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import model.Log;
import rombo.new_class.CommentsImplement;

/**
 * Class for Comment table based on DAO.
 * 
 *
 */
public class CommentsDB extends ManagerImplDB implements Dao<CommentsImplement> {
	
	private Log log = Log.getInstance();
	private ResultSet rs;
	private PreparedStatement prepared;
	private String query;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<CommentsImplement> read() {
		List<CommentsImplement> list = new LinkedList<>();

		try {
			query = "select * from COMMENT";
			rs = open().executeQuery(query);

			while (rs.next()) {
				list.add(new CommentsImplement(rs.getInt("idUser"), rs.getString("commento"),
						Optional.of(rs.getInt("idComment")), Optional.of(rs.getInt("idDiscussion")),
						rs.getDate("data")));
			}
			return list;
		} catch (SQLException e) {
			log.logWarning("Error while download comments\n" + e);
			return list;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean create(final CommentsImplement t) {
		try {

			query = "insert into COMMENT (idUser, idDiscussion, commento, data) values (?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, t.GetIDUser());
			prepared.setInt(2, t.GetIDDiscussion().get());
			prepared.setString(3, t.GetComment());
			prepared.setDate(4, java.sql.Date.valueOf(sdf.format(new Date())));

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("Error while adding new comment in discussion (idDiscussion = " + t.getIDDiscussion().get()
					+ "|idUser = " + t.getIDUser() + ")" + e);
			return false;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean update(final CommentsImplement t) {
		try {
			open();

			query = "update COMMENT set commento = ? where idComment= ?";
			prepared = super.getConn().prepareStatement(query);
			prepared.setString(1, t.GetComment());
			prepared.setInt(1, t.GetIDComment().get());
			prepared.executeUpdate();
			return true;

		} catch (SQLException e) {
			log.logWarning("Error while update comment (idComment= " + t.getIDComment().get() + ")" + e);
			return false;
		} finally {
			close();
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean delete(final Integer id) {
		try {
			open();

			query = "delete from COMMENT where idComment= ?";
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, id);
			prepared.executeUpdate();
			return true;

		} catch (SQLException e) {
			log.logWarning("Error while delete comment(idComment=" + id + ")" + e);
			return false;
		} finally {
			close();
		}
	}
}
