package model.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class DBLikeDislikeImpl extends DBManagerImpl implements DBLikeDislike {
	private class LikeSet {
		Boolean like;
		Boolean dislike;
		Integer idUser;

		LikeSet(final Boolean isLike, final Boolean isDislike, final Integer idUser) {
			this.like = isLike;
			this.dislike = isDislike;
			this.idUser = idUser;
		}

		public Boolean getLike() {
			return this.like;
		}

		public Boolean getDislike() {
			return this.dislike;
		}

		public Integer getIdUser() {
			return this.idUser;
		}

	}

	private String query;
	private PreparedStatement prepared;
	private ResultSet rs;

	private Optional<List<LikeSet>> getDataBase(final Integer idDiscussion) {
		List<LikeSet> list = new LinkedList<>();
		try {
			query = "select * from LIKES where idDiscussion= " + idDiscussion;
			rs = open().executeQuery(query);
			while (rs.next()) {
				list.add(new LikeSet(rs.getBoolean("isLike"), rs.getBoolean("isDislike"), rs.getInt("idUser")));
			}
			return Optional.of(list);
		} catch (SQLException e) {
			System.out.println("Error while delete comment" + e);
			return Optional.empty();
		} finally {
			close();
		}
	}
	
	private boolean setDataBase(final Integer idDiscussion, final Integer idUser, final boolean isLike, final boolean isDislike) {
		try {

			query = "insert into LIKES (idUser, idDiscussion, isLike, isDislike) values (?,?,?,?)";
			open();
			prepared = super.getConn().prepareStatement(query);
			prepared.setInt(1, idUser);
			prepared.setInt(2, idDiscussion);
			prepared.setBoolean(3, isLike);
			prepared.setBoolean(4, isDislike);
			
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
	public Integer getLike(Integer idDiscussion) {
		return this.getDataBase(idDiscussion).get().stream().filter(s -> s.getLike()).collect(Collectors.toList())
				.size();
	}

	@Override
	public Integer getDislike(Integer idDiscussion) {
		return this.getDataBase(idDiscussion).get().stream().filter(s -> s.getDislike()).collect(Collectors.toList())
				.size();
	}

	@Override
	public boolean isStillLiked(Integer idDiscussion, Integer idUser) {
		return !this.getDataBase(idDiscussion).get().stream().filter(s -> s.getLike() && s.getIdUser() == idUser).collect(Collectors.toList()).isEmpty();
	}

	@Override
	public boolean isStillDisliked(Integer idDiscussion, Integer idUser) {
		return !this.getDataBase(idDiscussion).get().stream().filter(s -> s.getDislike() && s.getIdUser() == idUser).collect(Collectors.toList()).isEmpty();

	}

	@Override
	public boolean addLike(Integer idDiscussion, Integer idUser) {
		return this.setDataBase(idDiscussion, idUser, true, false);
	}

	@Override
	public boolean addDislike(Integer idDiscussion, Integer idUser) {
		return this.setDataBase(idDiscussion, idUser, false, true);
	}

	

}
