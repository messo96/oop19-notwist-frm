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

import model.base.Discussion;
import model.base.DiscussionImpl;
import model.base.User;

public class DBDiscussion extends DBManagerImpl implements Dao<DiscussionImpl> {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date d;
	private ResultSet rs = null;
	private PreparedStatement prepared;
	private String query;

	@Override
	public List<DiscussionImpl> getAll() {
		List<DiscussionImpl> discussion = new LinkedList<>();

		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);

			while (rs.next()) {
				discussion.add(new DiscussionImpl(rs.getInt("idDiscussion"), rs.getInt("idUser"), rs.getString("title"),
						rs.getString("description"), new DBCategory().getAll().stream().filter(c -> {
							try {
								return c.getId() == rs.getInt("idMacro");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return false;
						}).findFirst().get(), rs.getDate("data")));
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

			d = new Date();
			query = "insert into DISCUSSION (idUser, title, description, idMacro,data) values (?,?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, t.getIdUser());
			prepared.setString(2, t.getTitle());
			prepared.setString(3, t.getDescription());
			prepared.setInt(4, new DBCategory().getAll().stream().filter(c -> c.getId() == t.getCategory().getId())
					.findFirst().get().getId());
			prepared.setDate(5, java.sql.Date.valueOf(sdf.format(d)));

			prepared.executeUpdate();
			System.out.println("Discussion create successfully( " + t.getTitle() + " | " + new DBUserImpl().getAll()
					.stream().filter(u -> u.getId() == t.getIdUser()).findFirst().get().getUsername() + " )");
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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		try {
			open();
			query = "delete from DISCUSSION where idDiscussion = ?";
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, id);
			prepared.executeUpdate();

			if (new DBComments().getAll().stream().filter(c -> c.GetIDDiscussion().get() == id).count() != 0) {
				query = "delete from COMMENT where idDiscussion = ?";
				prepared = super.getConn().prepareStatement(query);
				prepared.setInt(1, id);
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
