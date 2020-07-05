package etape5.metier;

/**
 * Représente une ligne de détail dans une commande.
 * Reprend la structure d'une ligne de détail du panier,
 * avec, en plus, une référence vers la commande associée.
 * @author Administrateur
 *
 */
public class DetailCommande {
	private Commande commande; 
	private Produit p;
	private int quantite;
	private double sousTotal;
	
	// crée un DetailCommande à partir d'un DetailPanier
	public DetailCommande(Commande commande, DetailPanier dp) {
		this.commande = commande;
		p = dp.getProduit();
		quantite = dp.getQuantite();
		sousTotal = dp.getSousTotal();
	}
	
	@Override
	public String toString() {
		return "Produit : " + p.getNom() + " " + p.getDescription() +
				", quté : " + quantite + ", sous total : " + sousTotal;
	}
	
}
