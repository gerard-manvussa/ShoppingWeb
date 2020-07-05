package etape3.metier;

import java.util.List;
import java.util.Vector;
/**
 * Repr�sente le catalogue des produits propos�s au visiteur.
 * Un seul objet de ce type devrait exister ("singleton").
 * Cet objet unique sera en lecture seule, une fois initialis�.
 * @author Administrateur
 *
 */
public class Catalogue {
	private List<Produit> produits;

	
	private Catalogue() {
		produits = new Vector<Produit>();
	}
	
	/**
	 * Retourne la liste des produits du catalogue
	 * @return
	 */
	public List<Produit> getListe() {
		return produits;
	}
	
	
}
