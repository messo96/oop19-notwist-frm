package test.model.database;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import rombo.new_class.*;
import rombo.new_class.Comments;
import model.base.*;
import model.database.*;

public class DBTest {

	private Dao<User> dbuser = new DBUserImpl();
	private Dao<DiscussionImpl> dbdiscussion = new DBDiscussion();
	private Dao<CommentsImplement> dbcomments = new DBComments();
	private DBStrike dbstrike = new DBStrikeImpl();
	private User testUser = new User(0, "test", "test", "test@test.com", false);

	@Test
	public void testDBUser() {

		assertTrue(dbuser.getAll().stream().filter(u -> u.getEmail().equals("test@test.com")).findFirst().isPresent());
		assertFalse(dbuser.create(new User(0, "test", "test", "test@test.com", false)));
		User compareUser = dbuser.getAll().stream()
				.filter(u -> u.getEmail().equals("test@test.com") && u.getPassword().equals("test")).findFirst().get();
		assertEquals(testUser.getId(), compareUser.getId());
		assertEquals(testUser.getUsername(), compareUser.getUsername());
		assertEquals(testUser.getEmail(), compareUser.getEmail());
		assertEquals(testUser.getPassword(), compareUser.getPassword());

	}

	@Test
	public void testDBDiscussionAndComments() {
		Category cat = new DBCategory().getAll().stream().filter(c -> c.getName().equals("SPORT"))
				.collect(Collectors.toList()).get(0);
		Date date = new Date();
		assertEquals(dbdiscussion.getAll().stream().filter(d -> d.getIdUser() == testUser.getId())
				.collect(Collectors.toList()).size(), 0);
		dbdiscussion.create(new DiscussionImpl(0, testUser.getId(), "TITLE TEST", "This is a description", cat, date));
		dbdiscussion.create(
				new DiscussionImpl(0, testUser.getId(), "TITLE SECOND TEST", "This is another description", cat, date));
		List<Discussion> discussionList = dbdiscussion.getAll().stream().filter(d -> d.getIdUser() == testUser.getId())
				.collect(Collectors.toList());
		assertEquals(discussionList.size(), 2);

		Discussion disc = discussionList.get(0);
		assertEquals(dbcomments.getAll().stream().filter(c -> c.GetIDDiscussion().get() == disc.getIdDiscussion())
				.collect(Collectors.toList()).size(), 0);
		assertTrue(dbcomments.create(new CommentsImplement(testUser.getId(), "I'm a comment!", Optional.empty(),
				Optional.of(disc.getIdDiscussion()), new Date())));
		assertEquals(dbcomments.getAll().stream().filter(c -> c.GetIDDiscussion().get() == disc.getIdDiscussion())
				.collect(Collectors.toList()).size(), 1);
		assertTrue(dbcomments.create(new CommentsImplement(testUser.getId(), "I'm another comment!", Optional.empty(),
				Optional.of(disc.getIdDiscussion()), new Date())));
		assertEquals(dbcomments.getAll().stream().filter(c -> c.GetIDDiscussion().get() == disc.getIdDiscussion())
				.collect(Collectors.toList()).size(), 2);

		List<Comments> commentList = dbcomments.getAll().stream()
				.filter(c -> c.GetIDDiscussion().get() == disc.getIdDiscussion()).collect(Collectors.toList());
		for (Comments c : commentList)
			assertTrue(dbcomments.delete(c.GetIDComment().get()));
		assertEquals(dbcomments.getAll().stream().filter(c -> c.GetIDDiscussion().get() == disc.getIdDiscussion())
				.collect(Collectors.toList()).size(), 0);

		for (Discussion d : discussionList)
			assertTrue(dbdiscussion.delete(d.getIdDiscussion()));

		assertEquals(dbdiscussion.getAll().stream().filter(d -> d.getIdUser() == testUser.getId())
				.collect(Collectors.toList()).size(), 0);

	}

	@Test
	public void testDBStrike() {

		assertTrue(dbstrike.getStrikes(testUser.getId()).equals(0));
		dbstrike.setStrike(testUser.getId(), 3);
		assertTrue(dbstrike.getStrikes(testUser.getId()).equals(3));
		dbstrike.resetStrike(testUser.getId());
		assertTrue(dbstrike.getStrikes(testUser.getId()).equals(0));

	}

}
