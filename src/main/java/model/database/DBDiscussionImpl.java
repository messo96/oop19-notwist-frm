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

public class DBDiscussionImpl extends DBManagerImpl implements DBDiscussion {

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	private Date d;
	private ResultSet rs = null;
	private PreparedStatement prepared;
	private String query;
	private final Integer MAX_TOP = 5;

	private Optional<List<Discussion>> getDataBase() {
		List<Discussion> discussion = new LinkedList<>();

		try {
			query = "select * from DISCUSSION";
			rs = open().executeQuery(query);

			while (rs.next()) {
				discussion.add(new DiscussionImpl(rs.getInt("idDiscussion"), rs.getInt("idUser"), rs.getString("title"),
						rs.getString("description"), new DBCategoryImpl().getCategoryById(rs.getInt("idMacro")),
						rs.getDate("data")));
			}
			return Optional.of(discussion);
		} catch (SQLException e) {
			System.out.println("Error while download discussion" + e);
			return Optional.empty();
		} finally {
			close();
		}
	}

	private boolean setDataBase(final Integer idUser, final String title, final String description,
			final String topic) {
		try {

			d = new Date();
			query = "insert into DISCUSSION (idUser, title, description, idMacro,data) values (?,?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, idUser);
			prepared.setString(2, title);
			prepared.setString(3, description);
			prepared.setInt(4, new DBCategoryImpl().getCategoryByName(topic).getId());
			prepared.setDate(5, java.sql.Date.valueOf(sdf.format(d)));

			prepared.executeUpdate();
			System.out.println("Discussion create successfully( " + title + " | "
					+ new DBUserImpl().getUserFromId(idUser).get() + " )");
			return true;
		} catch (Exception e) {
			System.out.println("\nError while adding new discussion " + e);
			return false;
		} finally {
			close();
		}
	}

	public Optional<List<Discussion>> getDiscussion(final User user) {
		return Optional.of(this.getDataBase().get().stream().filter(d -> d.getIdUser() == user.getId())
				.collect(Collectors.toList()));
	}

	public boolean createDiscussion(final Integer idUser, final String title, final String description,
			final String topic) {
		return this.setDataBase(idUser, title, description, topic);
	}

	@Override
	public Optional<List<Discussion>> getAllDiscussion() {
		return this.getDataBase();
	}

	@Override
	public Optional<List<Discussion>> getAllDiscussion(final String title) {
		return Optional.of(this.getDataBase().get().stream().filter(d -> d.getTitle().contains(title))
				.collect(Collectors.toList()));
	}

	@Override
	public Optional<List<Discussion>> getAllDiscussion(Category category) {
		return Optional.of(this.getDataBase().get().stream().filter(d -> d.getCategory().getId() == category.getId())
				.collect(Collectors.toList()));
	}

	@Override
	public Optional<Discussion> getDiscussionFromId(final Integer idDiscussion) {
		return Optional.of(this.getDataBase().get().stream().filter(d -> d.getIdDiscussion() == idDiscussion).findFirst().get());
	}

	@Override
	public List<Discussion> getTopDiscussion() {

		DBComments dbcomment = new DBCommentsImpl();
		return this.getDataBase().get().stream()
				.sorted((d1, d2) -> Integer.compare(dbcomment.getAllComments(d1.getIdDiscussion()).get().size(),
						dbcomment.getAllComments(d2.getIdDiscussion()).get().size()))
				.limit(MAX_TOP).collect(Collectors.toList());
	}

	@Override
	public boolean deleteDiscussion(final Integer idDiscussion) {

		try {
			open();
			query = "delete from DISCUSSION where idDiscussion = ?";
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, idDiscussion);
			prepared.executeUpdate();

			if (new DBCommentsImpl().getAllComments(idDiscussion).isPresent()) {
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
