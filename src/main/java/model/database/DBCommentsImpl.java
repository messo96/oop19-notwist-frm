package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import rombo.new_class.*;

public class DBCommentsImpl extends DBManagerImpl implements Dao<CommentsImplement> {

	private ResultSet rs;
	PreparedStatement prepared;
	private String query;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");


	@Override
	public List<CommentsImplement> getAll() {
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
			System.out.println("Error while download comments\n" + e);
			return list;
		} finally {
			close();
		}
	}

	@Override
	public boolean create(CommentsImplement t) {
		try {

			query = "insert into COMMENT (idUser, idDiscussion, commento, data) values (?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1,  t.GetIDUser());
			prepared.setInt(2, t.GetIDDiscussion().get());
			prepared.setString(3, t.GetComment());
			prepared.setDate(4, java.sql.Date.valueOf(sdf.format(new Date())));

			prepared.executeUpdate();
			return true;
		} catch (Exception e) {
			System.out.println("\nError while adding new comment in discussion " + e);
			return false;
		} finally {
			close();
		}
	}

	@Override
	public boolean update(CommentsImplement t) {
		try {
			open();

			query = "update COMMENT set commento = ? where idComment= ?";
			prepared = super.getConn().prepareStatement(query);
			prepared.setString(1, t.GetComment());
			prepared.setInt(1, t.GetIDComment().get());
			prepared.executeUpdate();
			return true;

		} catch (SQLException e) {
			System.out.println("Error while delete comment" + e);
			return false;
		} finally {
			close();
		}
	}

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
			System.out.println("Error while delete comment" + e);
			return false;
		} finally {
			close();
		}
	}
}
