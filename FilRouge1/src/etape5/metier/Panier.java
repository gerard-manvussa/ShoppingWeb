package etape5.metier;

import java.util.ArrayList;
import java.util.List;
/**
 * Le panier dans lequel le visiteur met ses options d'achat
 * (des objets DetailPanier). Une instance de cette classe est 
 * associé à un visiteur, dès qu'il décide de faire un achat.
 * Dans cette version on a utilisé une List plutôt qu'une map.
 * En effet le nombre d'articles étant relativement faible,
 * la recherche d'un doublon dans le panier, s'effectuant en
 * mémoire, devrait être rapide. 
 * Classe non persistante.
 * @author Administrateur
 *
 */
public class Panier {
	List<DetailPanier> options;
	
	// constructeurs
	public Panier() {
		options = new ArrayList<DetailPanier>();
	}
	
	// accesseurs
	public List<DetailPanier> getOptions() {
		return options;
	}

	
	// méthodes
	public double getTotal() {
		double total = 0;
		for (DetailPanier dp : options) {
			total += dp.getSousTotal();
		}
		return total;
	}
	/**
	 * Ajoute une option à ce panier
	 * @param option l'option à ajouter
	 */
	public void ajoutOption(DetailPanier option) {
		options.add(option);
	}
	/**
	 * Ajoute une option dans le panier en vérifiant si le 
	 * produit référencé ne s'y trouve pas déjà.
	 * @param produitCourant Le produit concerné
	 * @param quantite La quantité demandée
	 */
	public void ajoutOption(Produit produitCourant, int quantite) {
		// ce produit est il déjà référencé dans le panier ?
		// si ce produit est déjà référencé
		DetailPanier dp = rechercheDetailPanier(produitCourant);
		
		if (dp != null){
			dp.setQuantite(dp.getQuantite() + quantite);
			dp.setSousTotal(dp.getQuantite() * produitCourant.getPrix());
		} else {  // ce produit n'est pas dans le panier
			dp = new DetailPanier(produitCourant,quantite,quantite * produitCourant.getPrix());
			options.add(dp);
		}
	}
	/**
	 * Effectue un parcours du panier pour tenter d'y trouver un DetailPanier
	 * lié au Produit passé en paramètre.
	 * @param produitCourant Le produit courant, recherché dans le panier
	 * @return Le DetailPanier correspondant au Produit passé en entrée ou null, s'il n'est pas déjà
	 * 			présent dans le panier.
	 */
	private DetailPanier rechercheDetailPanier(Produit produitCourant) {
		for (DetailPanier dp : options) {
			if (dp.getProduit().getCode() == produitCourant.getCode())
				return dp;
		}
		return null;
	}
	
	
	/**
	 * Affiche le contenu du panier
	 */
	 @Override
	public String toString() {
		 StringBuilder sb = new StringBuilder();
		 if (options.size() == 0) {
			 sb.append("Votre panier est vide");
		 } else {
			 sb.append("Votre panier contient :\n");
			 for (DetailPanier dp:options) {
				 sb.append("- ");
				 sb.append(dp.getProduit().getNom());
				 sb.append(" - ");
				 sb.append(dp.getProduit().getDescription());
				 sb.append(", qute : ");
				 sb.append(String.valueOf(dp.getQuantite()));
				 sb.append(", total : ");
				 sb.append(String.valueOf(dp.getSousTotal()));
				 sb.append(".\n");
			 }
		 }
		return sb.toString();
	}	
}
