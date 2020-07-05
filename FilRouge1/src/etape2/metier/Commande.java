package etape2.metier;

import java.util.Date;
import java.util.List;
/**
 * Représente une commande passée par un client.
 * Elle reprend le contenu du panier, et les objets
 * DetailPanier serviront à créer les DetailCommande.
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
