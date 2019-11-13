package mediatheque;

public interface ItemVisitor {
	public void visit(CD cd);
	public void visit(Book b);	
}
