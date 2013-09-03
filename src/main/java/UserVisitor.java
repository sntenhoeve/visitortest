public interface UserVisitor {
//	public void visit(UnknownUser user);
//	public void visit(User user);
	public void visitUser(User user);
	public void visitUnknownUser(UnknownUser user);
}