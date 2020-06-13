package test.model.database;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Optional;

import org.junit.Test;

import model.base.*;
import model.database.*;

public class DBTest {

	private DBUser dbuser = new DBUserImpl();
	private DBDiscussion dbdiscussion = new DBDiscussionImpl();
	private DBComments dbcomments = new DBCommentsImpl();
	private DBStrike dbstrike = new DBStrikeImpl();
	private User testUser = new User(0, "test","test", "test@test.com", false);

	
	@Test
	public void testDBUser() {
		
		assertTrue(dbuser.existUser("test@test.com"));
		assertFalse(dbuser.register("test", "test", "test@test.com", false));
		assertEquals(dbuser.login("test@test.com", "t"), Optional.empty());
		User compareUser = dbuser.login("test@test.com", "test").get();
		assertEquals(testUser.getId(), compareUser.getId());
		assertEquals(testUser.getUsername(), compareUser.getUsername());
		assertEquals(testUser.getEmail(), compareUser.getEmail());
		assertEquals(testUser.getPassword(), compareUser.getPassword());
		
	}
	
	//DA FINIRE PERCHE' MANCA IMPLEMENTAZIONE DEL dbcomments.getAllDiscussion();
	@Test
	public void testDBDiscussionAndComments() {
		assertEquals(dbdiscussion.getDiscussion(testUser).get().size(), 0);
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is a description", "SPORT");
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE SECOND TEST", "This is a description", "SPORT");

		assertEquals(dbdiscussion.getDiscussion(testUser).get().size(),2);
		List<Discussion> discussionList = dbdiscussion.getDiscussion(testUser).get();
		
		Discussion disc = discussionList.get(0);
//		assertEquals(dbcomments.getAllComments(disc.getIdDiscussion()).get().size(), 0);
//		assertTrue(dbcomments.write(disc.getIdDiscussion(), testUser.getId(), "I'm a comment!"));
//		assertEquals(dbcomments.getAllComments(disc.getIdDiscussion()).get().size(), 1);
//		assertTrue(dbcomments.write(disc.getIdDiscussion(), testUser.getId(), "I'm another comment!"));
//		assertEquals(dbcomments.getAllComments(disc.getIdDiscussion()).get().size(), 2);
//		List<Comments> commentList = dbcomments.getAllComments(disc.getIdDiscussion()).get();
//		for(Comments c : commentList)
//			assertTrue(dbcomments.delete(c.GetID()));
//		assertEquals(dbcomments.getAllComments(disc.getIdDiscussion()).get().size(), 0);
//		
		for(Discussion d : discussionList) 
			assertTrue(dbdiscussion.deleteDiscussion(d.getIdDiscussion()));
		assertEquals(dbdiscussion.getDiscussion(testUser).get().size(), 0);
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
