package test.model.database;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.Test;

import model.base.*;
import model.database.*;

public class DBTest {

	private DBUser dbuser = new DBUserImpl();
	private DBDiscussion dbdiscussion = new DBDiscussionImpl();
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
	
	@Test
	public void testDBDiscussion() {
		assertEquals(dbdiscussion.getDiscussion(testUser).get().size(), 0);
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE TEST", "This is a description", "SPORT");
		dbdiscussion.createDiscussion(testUser.getId(), "TITLE SECOND TEST", "This is a description", "SPORT");

		assertEquals(dbdiscussion.getDiscussion(testUser).get().size(),2);
		List<Discussion> list = dbdiscussion.getDiscussion(testUser).get();
		for(Discussion d : list) {
			assertTrue(dbdiscussion.deleteDiscussion(d.getIdDiscussion()));
		}
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
	
	@Test
	public void testDB() {

		assertTrue(dbstrike.getStrikes(testUser.getId()).equals(0));
		dbstrike.setStrike(testUser.getId(), 3);
		assertTrue(dbstrike.getStrikes(testUser.getId()).equals(3));
		dbstrike.resetStrike(testUser.getId());
		assertTrue(dbstrike.getStrikes(testUser.getId()).equals(0));

	}
	

	
}
