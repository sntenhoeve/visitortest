
public class UnknownUser extends User {
	public UnknownUser(String name) {
		super("Unknown user");
	}
	
	//Noop null object
	public void accept(UserVisitor visitor) {
		visitor.visitUnknownUser(this);
	}
}
