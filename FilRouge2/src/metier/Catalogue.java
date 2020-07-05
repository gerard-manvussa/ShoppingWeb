package metier;

import java.util.List;
import java.util.Vector;


import persistance.ProduitDAO;
/**
 * Représente le catalogue des produits proposés au visiteur.
 * Un seul objet de ce type devrait exister ("singleton").
 * Cet objet unique sera en lecture seule, une fois initialisé.
 * @author Administrateur
 *
 */
public class Catalogue {
	private List<Produit> produits;
	private static Catalogue leCatalogue = null;
	
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
	
	/**
	 * Ajoute un produit au catalogue
	 * @param p le produit à ajouter
	 */
	public void ajoutProduit(Produit p) {
		produits.add(p);
	}
	/**
	 * Retourne le nombre de produits au catalogue
	 * @return
	 */
	public int getNbProduits() {
		return produits.size();
	}
	
	public static Catalogue getInstance() {
		if (leCatalogue == null) {
			leCatalogue = new Catalogue();
			leCatalogue.initCatalogue();
		}
		return leCatalogue;
	}
	// initialise le catalogue avec des produits
	private void initCatalogue() {
		try {
			ProduitDAO dao = new ProduitDAO();
			produits = dao.chargeProduits();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
//		produits.add(new Produit(1,"Pat Metheny", "from This Place",10.12,null));
//		produits.add(new Produit(2,"Pat Metheny", "One Quiet Night",11.64,null));
//		produits.add(new Produit(3,"John Scofield", "Swallow Tales",21.99,null));
//		produits.add(new Produit(4,"Miles Davis", "Kind of Blue",3.35,null));
//		produits.add(new Produit(5,"Larry Coryell", "Spaces",24.38,null));
		
	}
}
