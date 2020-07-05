package etape3.metier;

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
