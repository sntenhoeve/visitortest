import junit.framework.Assert;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class UserTest {
	
	@Test
	public void testSendEmail() {
		UserService userService = new UserService();
		User user = new User("Joost");
		userService.sendEmail(user, "TEST");
		Assert.assertTrue(hasReceivedEmail(user, "TEST"));
	}
	
	@Test
	public void sendMailToNonExistingUser() {
		UserService userService = new UserService();
		User unknownUser = new UnknownUser("");
		userService.sendEmail(unknownUser, "TEST");
		Assert.assertTrue(hasNotReceivedEmail(unknownUser, "TEST"));
	}
	
	@Test
	public void testGetDetailsOfUser() {
		UserService userService = new UserService();
		assertEquals("Joost", userService.getDetails(new User("Joost")));		
	}
	
	@Test
	public void testGetDetailsOfNonExistingUser() {
		UserService userService = new UserService();
		assertEquals("Unknown user", userService.getDetails(new UnknownUser("")));
	}

	private boolean hasNotReceivedEmail(User user, String message) {
		return !hasReceivedEmail(user, message);
	}

	private boolean hasReceivedEmail(User user, String message) {
		return user.messages.contains(message);
	}
	
	
}
