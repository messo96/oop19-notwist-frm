package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import controller.database.DBCategoryImpl;
import controller.database.DBCommentsImpl;
import controller.database.DBUserImpl;
import model.base.Discussion;
import model.base.DiscussionImpl;
import model.base.User;

public class DBDiscussion extends DBManagerImpl implements Dao<DiscussionImpl> {

	private DBCategoryImpl dbcategory = new DBCategoryImpl();
	private DBCommentsImpl dbcomments = new DBCommentsImpl();
	private DBUserImpl dbuser = new DBUserImpl();
	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private ResultSet rs = null;
	private PreparedStatement prepared;
	private String query;

	@Override
	public List<DiscussionImpl> read() {
		List<DiscussionImpl> discussion = new LinkedList<>();

		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);

			while (rs.next()) {
				discussion.add(new DiscussionImpl(rs.getInt("idDiscussion"), rs.getInt("idUser"), rs.getString("title"),
						rs.getString("description"), dbcategory.getCategory(rs.getInt("idMacro")).get(), rs.getDate("data")));
			}
			return discussion;
		} catch (SQLException e) {
			System.out.println("Error while download discussion" + e);
			return discussion;
		} finally {
			close();
		}
	}

	@Override
	public boolean create(DiscussionImpl t) {
		try {
			query = "insert into DISCUSSION (idUser, title, description, idMacro,data) values (?,?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, t.getIdUser());
			prepared.setString(2, t.getTitle());
			prepared.setString(3, t.getDescription());
			prepared.setInt(4, t.getCategory().getId());
			prepared.setDate(5, java.sql.Date.valueOf(sdf.format(t.getData())));

			prepared.executeUpdate();
			System.out.println("Discussion create successfully( " + t.getTitle() + " | "
					+ dbuser.getUser(t.getIdUser()).get().getUsername() + " )");
			return true;
		} catch (Exception e) {
			System.out.println("\nError while adding new discussion " + e);
			return false;
		} finally {
			close();
		}
	}

	@Override
	public boolean update(DiscussionImpl t) {
		// Cannot edit a published discussion
		return false;
	}

	@Override
	public boolean delete(Integer idDiscussion) {
		try {
			open();
			query = "delete from DISCUSSION where idDiscussion = ?";
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, idDiscussion);
			prepared.executeUpdate();

			if (dbcomments.getComments(idDiscussion).get().size() != 0) {
				query = "delete from COMMENT where idDiscussion = ?";
				prepared = super.getConn().prepareStatement(query);
				prepared.setInt(1, idDiscussion);
				prepared.executeUpdate();
			}

			return true;

		} catch (SQLException e) {
			System.out.println("Error while delete discussion and attached comments" + e);
			return false;
		} finally {
			close();
		}
	}

}
