package etape5.metier;

/**
 * Repr�sente une ligne de d�tail dans une commande.
 * Reprend la structure d'une ligne de d�tail du panier,
 * avec, en plus, une r�f�rence vers la commande associ�e.
 * @author Administrateur
 *
 */
public class DetailCommande {
	private Commande commande; 
	private Produit p;
	private int quantite;
	private double sousTotal;
	
	// cr�e un DetailCommande � partir d'un DetailPanier
	public DetailCommande(Commande commande, DetailPanier dp) {
		this.commande = commande;
		p = dp.getProduit();
		quantite = dp.getQuantite();
		sousTotal = dp.getSousTotal();
	}
	
	@Override
	public String toString() {
		return "Produit : " + p.getNom() + " " + p.getDescription() +
				", qut� : " + quantite + ", sous total : " + sousTotal;
	}
	
}
