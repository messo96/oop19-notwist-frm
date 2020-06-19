package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import main.Log;
import model.base.LikeSet;

/**
 * Class for Likes table based on DAO
 * 
 * @author gio
 *
 */
public class DBLikeDislike extends DBManagerImpl implements Dao<LikeSet> {
	private Log log = Log.getInstance();
	private String query;
	private PreparedStatement prepared;
	private ResultSet rs;

	@Override
	public List<LikeSet> read() {
		List<LikeSet> list = new LinkedList<>();
		try {
			query = "select * from LIKES";
			rs = open().executeQuery(query);
			while (rs.next()) {
				list.add(new LikeSet(rs.getInt("idLikes"), rs.getBoolean("isLike"), rs.getBoolean("isDislike"),
						rs.getInt("idUser"), rs.getInt("idDiscussion")));
			}
			return list;
		} catch (SQLException e) {
			log.logWarning("Error while download all likes and dislikes of all discussions" + e);
			return list;
		} finally {
			close();
		}
	}

	@Override
	public boolean create(LikeSet t) {
		try {
			query = "insert into LIKES (idUser, idDiscussion, isLike, isDislike) values (?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, t.getIdUser());
			prepared.setInt(2, t.getIdDiscussion());
			prepared.setBoolean(3, t.getLike());
			prepared.setBoolean(4, t.getDislike());

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("\nError while adding new like/dislike in discussion " + e);
			return false;
		} finally {
			close();
		}
	}

	@Override
	public boolean update(LikeSet t) {
		try {
			query = "update LIKES set isLike= ?, isDislike= ? where idUser= ? AND idDiscussion= ?";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setBoolean(1, t.getLike());
			prepared.setBoolean(2, t.getDislike());
			prepared.setInt(3, t.getIdUser());
			prepared.setInt(4, t.getIdDiscussion());

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("\nError while update like or dislike in discussion (idLikes= " + t.getId() + ")" + e);
			return false;
		} finally {
			close();
		}
	}

	@Override
	public boolean delete(Integer id) {
		try {
			query = "delete from LIKES where idLikes = ?";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, id);

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			log.logWarning("\nError while delete like in discussion (id=" + id + ")" + e);
			return false;
		} finally {
			close();
		}
	}

}
