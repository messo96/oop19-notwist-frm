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

import model.base.Category;
import model.base.Discussion;
import model.base.DiscussionImpl;
import model.base.User;
import rombo.new_class.Comments;

public class DBDiscussionImpl extends DBManagerImpl implements Dao<DiscussionImpl> {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date d;
	private ResultSet rs = null;
	private PreparedStatement prepared;
	private String query;

	private Optional<List<Discussion>> getDataBase() {
		List<Discussion> discussion = new LinkedList<>();

		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);

			while (rs.next()) {
				discussion.add(new DiscussionImpl(rs.getInt("idDiscussion"), rs.getInt("idUser"), rs.getString("title"),
						rs.getString("description"), new DBCategoryImpl().getAll().stream().filter(c -> {
							try {
								return c.getId() == rs.getInt("idMacro");
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
							return false;
						}).findFirst().get(), rs.getDate("data")));
			}
			return Optional.of(discussion);
		} catch (SQLException e) {
			System.out.println("Error while download discussion" + e);
			return Optional.empty();
		} finally {
			close();
		}
	}

	public Optional<List<Discussion>> getDiscussion(final User user) {
		return Optional.of(this.getDataBase().get().stream().filter(d -> d.getIdUser() == user.getId())
				.collect(Collectors.toList()));
	}

	@Override
	public List<DiscussionImpl> getAll() {
		List<DiscussionImpl> discussion = new LinkedList<>();

		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);

			while (rs.next()) {
				discussion.add(new DiscussionImpl(rs.getInt("idDiscussion"), rs.getInt("idUser"), rs.getString("title"),
						rs.getString("description"), new DBCategoryImpl().getAll().stream().filter(c -> {
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
			prepared.setInt(4, new DBCategoryImpl().getAll().stream()
					.filter(c -> c.getId() == t.getCategory().getId()).findFirst().get().getId());
			prepared.setDate(5, java.sql.Date.valueOf(sdf.format(d)));

			prepared.executeUpdate();
			System.out.println("Discussion create successfully( " + t.getTitle() + " | "
					+ new DBUserImpl().getUserFromId(t.getIdUser()).get() + " )");
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

			if (!new DBCommentsImpl().getAll().stream().filter(c -> c.GetIDDiscussion().get() == id)
					.collect(Collectors.toList()).isEmpty()) {
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

//	return this.getDataBase().get().stream()
//			.sorted((d1, d2) -> Integer.compare(
//					dbcomment.getAll().stream().filter(c -> c.GetIDDiscussion().get() == d1.getIdDiscussion())
//							.collect(Collectors.toList()).size(),
//					dbcomment.getAll().stream().filter(c -> c.GetIDDiscussion().get() == d2.getIdDiscussion())
//							.collect(Collectors.toList()).size()))
//			.limit(MAX_TOP).collect(Collectors.toList());

}
