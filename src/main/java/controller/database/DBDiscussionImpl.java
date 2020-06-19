package controller.database;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.base.Category;
import model.base.DiscussionImpl;
import model.database.DBDiscussion;

public class DBDiscussionImpl {
	private DBDiscussion dbd = new DBDiscussion();
	private DBCommentsImpl dbcomments = new DBCommentsImpl();
	private final Integer MAX_TOP = 5;

	public List<DiscussionImpl> getAll() {
		return dbd.read();
	}

	public boolean createDiscussion(final Integer idUser, final String title, final String description,
			final Category category) {
		return dbd.create(new DiscussionImpl(0, idUser, title, description, category, new Date()));
	}

	public Optional<DiscussionImpl> getDiscussion(final Integer idDiscussion) {
		return dbd.read().stream().filter(d -> d.getIdDiscussion() == idDiscussion).findFirst();
	}

	public Optional<List<DiscussionImpl>> getDiscussion(final String title) {
		return Optional.of(dbd.read().stream().filter(d -> d.getTitle().contains(title)).collect(Collectors.toList()));
	}

	public Optional<List<DiscussionImpl>> getDiscussion(final Category category) {
		return Optional.of(dbd.read().stream().filter(d -> d.getCategory().getId() == category.getId())
				.collect(Collectors.toList()));
	}

	public Optional<List<DiscussionImpl>> getDiscussions(final Integer idUser) {
		return Optional.of(dbd.read().stream().filter(d -> d.getIdUser() == idUser).collect(Collectors.toList()));
	}

	public Optional<List<DiscussionImpl>> getTopDiscussion() {
		return Optional.of(dbd.read().stream()
				.sorted((d1, d2) -> Integer.compare(dbcomments.getComments(d1.getIdDiscussion()).get().size(),
						dbcomments.getComments(d2.getIdDiscussion()).get().size()))
				.limit(MAX_TOP).collect(Collectors.toList()));
	}
	
	public boolean remove(final Integer idDiscussion) {
		return dbd.delete(idDiscussion);
	}

}
