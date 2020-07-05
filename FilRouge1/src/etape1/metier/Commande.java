package etape1.metier;

import java.util.Date;
/**
 * Représente une commande passée par un client.
 * Elle reprend le contenu du panier, et les objets
 * DetailPanier serviront à créer les DetailCommande.
 * @author Administrateur
 *
 */
public class Commande {
	private Integer no;	     // une ruse : null voudra dire 'non encore enregistré' 
	private Date dateCommande;
	private double total;

}
