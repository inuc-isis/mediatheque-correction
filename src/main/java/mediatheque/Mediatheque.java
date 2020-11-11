package mediatheque;

import java.util.LinkedList;
import java.util.List;

public class Mediatheque {

    private final List<Item> items = new LinkedList<>();

    public static void main(String[] args) {
        Mediatheque mediatheque = new Mediatheque();

        mediatheque.addItem(new Book("J.R.R. Tolkien", "Le seigneur des anneaux"));
        mediatheque.addItem(new Book("Philip K. Dick", "Le Maître du haut chateau"));
        mediatheque.addItem(new CD(12, "Sergeant Peppers"));
        System.out.println("On imprime toute le catalogue");
        mediatheque.printCatalog();
        System.out.println("On imprime seulement les livres");
        mediatheque.printOnlyBooks();
        System.out.println("On imprime seulement les CD");
        mediatheque.printOnlyCDs();
    }

    public void addItem(Item i) {
        items.add(i);
    }

    public void printCatalog() {
        accept(new ItemPrinter());
    }

    public void printOnlyBooks() {
        accept(new BookPrinter());
        
        /* On peut aussi l'écrire avec une classe interne anonyme
		accept( 
			// Classe interne anonyme qui désactive une méthode
			new ItemPrinter() {
				@Override
				public void visit(CD cd) {  } // On ne fait rien
			} 
		);
         */
    }

    public void printOnlyCDs() {
        accept(new CDPrinter());
        
        /* On peut aussi l'écrire avec une classe interne anonyme           
		accept( 
			new ItemPrinter() {
				@Override
				public void visit(Book b) { } // On ne fait rien
			} 
		);
         */
    }

    private void accept(ItemVisitor v) {
        for (Item i : items) {
            i.accept(v);
        }
    }
}
