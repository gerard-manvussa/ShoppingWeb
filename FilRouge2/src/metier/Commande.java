package metier;

import java.util.ArrayList;
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
	
	// constructeur
	public Commande(Client client, Integer no, Date dateCommande, double total) {
		this.client = client;
		this.no = no;
		this.dateCommande = dateCommande;
		this.total = total;
		details = new ArrayList<DetailCommande>();
	}
	
	// accesseurs
	public Integer getNo() {
		return no;
	}
	public void setNo(Integer no) {
		this.no = no;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<DetailCommande> getDetails() {
		return details;
	}	
	
	// methodes
	/**
	 * Ajoute une ligne de détail à cette commande, à partir
	 * d'une option d'achat du panier.
	 * @param dp Le DetailPanier à ajouter
	 */
	public void ajouteDetailCommande(DetailPanier dp) {
		details.add(new DetailCommande(this,dp));
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Commande no ");
		sb.append(String.valueOf(no));
		sb.append(", ");
		sb.append(client.toString());
		sb.append(", total : ");
		sb.append(String.valueOf(total));
		sb.append(" :\n");
		for (DetailCommande dc : details) {
			sb.append(" - " + dc + "\n");
		}
		return sb.toString();
	}
}
