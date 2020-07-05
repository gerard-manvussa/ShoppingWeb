package service;

import java.util.Date;

import metier.Catalogue;
import metier.Client;
import metier.Commande;
import metier.DetailPanier;
import metier.Panier;
import metier.Produit;
/**
 * Représente la façade applicative (couche de services).
 * Regroupe les traitements nécessaire à une session 
 * de consultation / achat d'un visiteur.
 * @author Administrateur
 *
 */
public class Facade {
	private Catalogue leCatalogue;
	int positionCourante = -1;
	
	// le panier et la commande éventuelle
	private Panier panier;
	private Commande cmd;
	
	// le client associé (éventuel)
	private Client client;
	
	// constructeur
	public Facade() {
		leCatalogue = Catalogue.getInstance();
	}
	

	/**
	 * Simule une page de visualisation d'un produit
	 * en parcourant le catalogue
	 * @return Une chaine représentant le détail du produit
	 */
	public String parcoursCatalogue() {
		positionCourante++;
		if (positionCourante == leCatalogue.getNbProduits()) 
			positionCourante = 0;
		String produitCourant = leCatalogue.getListe().get(positionCourante).toString();
		return produitCourant;
	}
	/**
	 * Simule un ajout au panier du produit couremment examiné.
	 * @param quantite
	 */
	public void ajoutePanier(int quantite) {
		if (panier == null) {	// crée le panier lors du premier achat
			panier = new Panier();
		}
		Produit produitCourant = leCatalogue.getListe().get(positionCourante);
		
		panier.ajoutOption(produitCourant,quantite);
	}
	/**
	 * Affiche le contenu du panier
	 * @return Une chaine décrivant le panier
	 */
	public String affichePanier() {
		return panier.toString();
	}

	/** 
	 * Passe commande en transformant le panier en une commande.
	 * @return
	 */
	public Commande passeCommande() {
		if ((cmd == null)&&(client != null)) {
			// création de la commande
			cmd = new Commande(client, null, new Date(), panier.getTotal());
			// ajout des détails de la commande
			for (DetailPanier dp : panier.getOptions()) {
				cmd.ajouteDetailCommande(dp);
			}
		}  // else ?
		return cmd;
	}
	/**
	 * Affiche les données d'une commande et de ses détails.
	 * Délègue ce travail à la méthode toString() de Commande
	 * @return La représentation chaine de l'objet commande
	 */
	public String afficheCommande() {
		if (cmd != null) {
			return cmd.toString();
		}
		return null;
	}

	/**
	 * Collecte les informations pour définir un nouveau client. 
	 * @param prenom Le prenom du client
	 * @param nom Le nom du client
	 * @param adresse L'adresse du client
	 */
	public void saisieInfosClient(String prenom, String nom, String adresse) {
		if (client == null) {
			client = new Client(nom, prenom, adresse);
		}	// else ?
	}
	
}
