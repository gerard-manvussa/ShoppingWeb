package etape2.metier;

import java.util.List;
import java.util.Vector;
/**
 * Représente le catalogue des produits proposés au visiteur.
 * Un seul objet de ce type devrait exister ("singleton").
 * Cet objet unique sera en lecture seule, une fois initialisé.
 * @author Administrateur
 *
 */
public class Catalogue {
	private List<Produit> produits;
}
