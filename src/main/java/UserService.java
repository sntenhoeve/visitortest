public class UserService {

	public void sendEmail(User user, String message) {
		user.accept(new EmailSendingUserVisitor(message));
	}
	
	public String getDetails(User user) {
		PrintingUserVisitor visitor = new PrintingUserVisitor(); 
		user.accept(visitor);
		return visitor.result;
	}

	private class EmailSendingUserVisitor implements UserVisitor {
		private String message;

		public EmailSendingUserVisitor(String message) {
			this.message = message;
		}

		public void visitUser(User user) {
			user.messages.add(message);
		}

		public void visitUnknownUser(UnknownUser user) {
			// Noop
		}
	}
	
	public static class PrintingUserVisitor implements UserVisitor {
		public String result;

		public void visitUnknownUser(UnknownUser user) {
			result = user.name;
		}

		public void visitUser(User user) {
			result = user.name;
		}

	}
}
