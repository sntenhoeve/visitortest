import java.util.ArrayList;
import java.util.List;


public class User {
	private String email;
	public List<String> messages = new ArrayList<String>();
	public String name;
	
	public User(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}

	public void accept(UserVisitor visitor) {
		visitor.visitUser(this);
	}
}
