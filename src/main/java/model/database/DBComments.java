package model.database;


import java.util.List;
import java.util.Optional;

import model.base.Comments;

public interface DBComments {

	public Optional<List<Comments>> getAllComments(final Integer idDiscussion);
	public boolean write(final Integer idDiscussion, final Integer idUser, final String comment);

}

