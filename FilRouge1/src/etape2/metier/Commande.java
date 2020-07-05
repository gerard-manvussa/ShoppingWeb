package etape2.metier;

import java.util.Date;
import java.util.List;
/**
 * Repr�sente une commande pass�e par un client.
 * Elle reprend le contenu du panier, et les objets
 * DetailPanier serviront � cr�er les DetailCommande.
 * @author Administrateur
 *
 */
public class Commande {
	private Integer no;
	private Date dateCommande;
	private double total;
	
	private Client client;
	private List<DetailCommande> details;
	
	
}
