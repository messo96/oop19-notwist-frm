package controller.database;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.database.DBComments;
import rombo.new_class.CommentsImplement;

public class DBCommentsImpl {
	private DBComments dbc = new DBComments();

	public Optional<List<CommentsImplement>> getComments(final Integer idDiscussion){
		return Optional.of(dbc.read().stream()
				.filter(c -> c.GetIDDiscussion().get() == idDiscussion).collect(Collectors.toList()));
	}
	
	public boolean createComment(final Integer idDiscussion, final Integer idUser, final String comment) {
		return dbc.create(new CommentsImplement(idUser, comment, Optional.empty(), Optional.of(idDiscussion), new Date()));
	}
	
	public boolean removeComment(final Integer idComment) {
		return dbc.delete(idComment);
	}
}
