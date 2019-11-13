
package mediatheque;

public class ItemPrinter implements ItemVisitor {

	@Override
	public void visit(CD cd) {
		System.out.println(cd);
	}

	@Override
	public void visit(Book b) {
		System.out.println(b);
	}
	
}
