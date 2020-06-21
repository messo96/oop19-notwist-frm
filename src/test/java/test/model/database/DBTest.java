package test.model.database;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import controller.database.CategoryImplDB;
import controller.database.CommentsImplDB;
import controller.database.DiscussionImplDB;
import controller.database.LikeDislikeImplDiscussionDB;
import controller.database.StrikeImplDB;
import controller.database.UserImplDB;
import rombo.new_class.*;
import rombo.new_class.Comments;
import model.base.*;

public class DBTest {

	private UserImplDB dbuser = new UserImplDB();
	private DiscussionImplDB dbdiscussion = new DiscussionImplDB();
	private CommentsImplDB dbcomments = new CommentsImplDB();
	private CategoryImplDB dbcategory = new CategoryImplDB();
	private StrikeImplDB dbstrike = new StrikeImplDB();
	private LikeDislikeImplDiscussionDB dblike = new LikeDislikeImplDiscussionDB();
	private User testUser = new User(0, "test", "test", "test@test.com", false);
	Optional<CategoryImpl> cat = dbcategory.getCategory("SPORT");

	@Test
	public void testDBUser() {

		// assertTrue(dbuser.existUser("test@test.com"));
		assertFalse(dbuser.register("test", "test", "test@test.com", false));
		User compareUser = dbuser.login("test@test.com", "test").get();
		assertEquals(testUser.getId(), compareUser.getId());
		assertEquals(testUser.getUsername(), compareUser.getUsername());
		assertEquals(testUser.getEmail(), compareUser.getEmail());
		assertEquals(testUser.getPassword(), compareUser.getPassword());

	}

	@Test
	public void testDBDiscussion() {
		assertNotEquals(cat, Optional.empty());
		assertEquals(dbdiscussion.getDiscussions(testUser.getId()).get().size(), 0);
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is a description", cat.get());
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is another description", cat.get());
		List<DiscussionImpl> discussionList = dbdiscussion.getDiscussions(testUser.getId()).get();

		assertEquals(discussionList.size(), 2);

		for (Discussion d : discussionList)
			assertTrue(dbdiscussion.remove(d.getIdDiscussion()));

		assertEquals(dbdiscussion.getDiscussions(testUser.getId()).get().size(), 0);

	}

	@Test
	public void testDBLikes() {
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is a description", cat.get());
		DiscussionImpl disc = dbdiscussion.getDiscussions(testUser.getId()).get().get(0);

		assertTrue(dblike.getLikes(disc.getIdDiscussion()) == 0);
		assertTrue(dblike.getDislikes(disc.getIdDiscussion()) == 0);
		dblike.setLike(disc.getIdDiscussion(), testUser.getId());
		assertTrue(dblike.getLikes(disc.getIdDiscussion()) == 1);
		dblike.setLike(disc.getIdDiscussion(), testUser.getId());
		assertTrue(dblike.getLikes(disc.getIdDiscussion()) == 0);
		dblike.setDislike(disc.getIdDiscussion(), testUser.getId());
		assertTrue(dblike.getDislikes(disc.getIdDiscussion()) == 1);
		dblike.setDislike(disc.getIdDiscussion(), testUser.getId());
		assertTrue(dblike.getDislikes(disc.getIdDiscussion()) == 0);

		assertTrue(dbdiscussion.remove(disc.getIdDiscussion()));

	}

	@Test
	public void testDBComments() {
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is a description", cat.get());
		DiscussionImpl disc = dbdiscussion.getDiscussions(testUser.getId()).get().get(0);

		// comment side
		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 0);
		assertTrue(dbcomments.createComment(disc.getIdDiscussion(), testUser.getId(), "I'm a comment!"));
		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 1);

		assertTrue(dbcomments.createComment(disc.getIdDiscussion(), testUser.getId(), "I'm another comment!"));

		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 2);

		List<CommentsImplement> commentList = dbcomments.getComments(disc.getIdDiscussion()).get();
		for (Comments c : commentList)
			assertTrue(dbcomments.removeComment(c.GetIDComment().get()));
		assertEquals(dbcomments.getComments(disc.getIdDiscussion()).get().size(), 0);

		assertTrue(dbdiscussion.remove(disc.getIdDiscussion()));

	}

	@Test
	public void testDBStrike() {

		assertTrue(dbstrike.getStrike(testUser.getId()) == 0);
		dbstrike.setStrike(testUser.getId(), 3);
		assertTrue(dbstrike.getStrike(testUser.getId()) == 3);
		dbstrike.reset(testUser.getId());
		assertTrue(dbstrike.getStrike(testUser.getId()) == 0);
	}


}
