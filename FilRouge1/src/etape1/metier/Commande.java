package etape1.metier;

import java.util.Date;
/**
 * Repr�sente une commande pass�e par un client.
 * Elle reprend le contenu du panier, et les objets
 * DetailPanier serviront � cr�er les DetailCommande.
 * @author Administrateur
 *
 */
public class Commande {
	private Integer no;	     // une ruse : null voudra dire 'non encore enregistr�' 
	private Date dateCommande;
	private double total;

}
