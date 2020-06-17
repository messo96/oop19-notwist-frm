package controller.database;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.database.DBComments;
import rombo.new_class.CommentsImplement;

public class DBCommentsImpl extends DBComments{

	public Optional<List<CommentsImplement>> getComments(final Integer idDiscussion){
		return Optional.of(super.read().stream()
				.filter(c -> c.GetIDDiscussion().get() == idDiscussion).collect(Collectors.toList()));
	}
}
