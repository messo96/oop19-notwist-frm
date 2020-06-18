package test.model.database;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.junit.Test;

import controller.database.DBCategoryImpl;
import controller.database.DBCommentsImpl;
import controller.database.DBDiscussionImpl;
import controller.database.DBStrikeImpl;
import controller.database.DBUserImpl;
import rombo.new_class.*;
import rombo.new_class.Comments;
import model.base.*;
import model.database.*;

public class DBTest {

	private DBUserImpl dbuser = new DBUserImpl();
	private DBDiscussionImpl dbdiscussion = new DBDiscussionImpl();
	private DBCommentsImpl dbcomments = new DBCommentsImpl();
	private DBCategoryImpl dbcategory = new DBCategoryImpl();
	private DBStrikeImpl dbstrike = new DBStrikeImpl();
	private User testUser = new User(0, "test", "test", "test@test.com", false);

	@Test
	public void testDBUser() {

		assertTrue(dbuser.existUser("test@test.com"));
		assertFalse(dbuser.create(new User(0, "test", "test", "test@test.com", false)));
		User compareUser = dbuser.login("test@test.com", "test").get();
		assertEquals(testUser.getId(), compareUser.getId());
		assertEquals(testUser.getUsername(), compareUser.getUsername());
		assertEquals(testUser.getEmail(), compareUser.getEmail());
		assertEquals(testUser.getPassword(), compareUser.getPassword());

	}

	@Test
	public void testDBDiscussionAndComments() {
		Optional<CategoryImpl> cat = dbcategory.getCategory("SPORT");
		//Date date = new Date();
		assertNotEquals(cat, Optional.empty());
		assertEquals(dbdiscussion.getDiscussions(testUser.getId()).get().size(), 0);
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is a description", cat.get());
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is another description", cat.get());
		List<DiscussionImpl> discussionList = dbdiscussion.getDiscussions(testUser.getId()).get();

		assertEquals(discussionList.size(), 2);

		Discussion disc = discussionList.get(0);
		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 0);
		assertTrue(dbcomments.create(new CommentsImplement(testUser.getId(), "I'm a comment!", Optional.empty(),
				Optional.of(disc.getIdDiscussion()), new Date())));
		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 1);

		assertTrue(dbcomments.create(new CommentsImplement(testUser.getId(), "I'm another comment!", Optional.empty(),
				Optional.of(disc.getIdDiscussion()), new Date())));
		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 2);

		List<CommentsImplement> commentList = dbcomments.getComments(disc.getIdDiscussion()).get();
		for (Comments c : commentList)
			assertTrue(dbcomments.delete(c.GetIDComment().get()));
		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 0);

		for (Discussion d : discussionList)
			assertTrue(dbdiscussion.delete(d.getIdDiscussion()));

		assertEquals(dbdiscussion.getDiscussions(testUser.getId()).get().size(), 0);

	}

	@Test
	public void testDBStrike() {

		assertTrue(dbstrike.getStrike(testUser.getId()) == 0 );
		dbstrike.setStrike(testUser.getId(), 3);
		assertTrue(dbstrike.getStrike(testUser.getId()) == 3 );
		dbstrike.reset(testUser.getId());
		assertTrue(dbstrike.getStrike(testUser.getId()) == 0);

	}

}
