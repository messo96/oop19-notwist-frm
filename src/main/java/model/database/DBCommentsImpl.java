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



public class DBCommentsImpl extends DBManagerImpl implements DBComments{

	private ResultSet rs;
	PreparedStatement prepared;
	private String query;
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public Optional<List<Comments>> getAllComments(final Integer idDiscussion) {
		List<Comments> list = new LinkedList<>();

		try {
			query = "select * from COMMENT where idDiscussion= " + idDiscussion;
			rs = open().executeQuery(query);

			while (rs.next()) {
				 list.add(new CommentsImplement(rs.getInt("idUser"), rs.getString("commento"),
						 							Optional.of(rs.getInt("idComment")), Optional.of(rs.getInt("idDiscussion")), rs.getDate("data")));
			}
			return Optional.of(list);
		} catch (SQLException e) {
			System.out.println("Error while download comments\n" + e);
			return Optional.empty();
		} finally {
			close();
		}
	}

	public boolean write(final Integer idDiscussion, final Integer idUser, final String comment) {
		try {

			query = "insert into COMMENT (idUser, idDiscussion, commento, data) values (?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, idUser);
			prepared.setInt(2, idDiscussion);
			prepared.setString(3, comment);
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
	
	public boolean delete(final Integer idComment) {
		try {
			open();
			
				query = "delete from COMMENT where idComment= ?";
				prepared = super.getConn().prepareStatement(query);
				prepared.setInt(1, idComment);
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
