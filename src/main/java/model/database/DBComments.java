package model.database;


import java.util.List;
import java.util.Optional;

import rombo.new_class.Comments;


public interface DBComments {

	public Optional<List<Comments>> getAllComments(final Integer idDiscussion);
	public boolean write(final Integer idDiscussion, final Integer idUser, final String comment);
	public boolean delete(final Integer idComment);

}

