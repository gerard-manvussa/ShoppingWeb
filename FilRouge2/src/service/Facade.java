package service;

import java.util.Date;

import metier.Catalogue;
import metier.Client;
import metier.Commande;
import metier.DetailPanier;
import metier.Panier;
import metier.Produit;
/**
 * Repr�sente la fa�ade applicative (couche de services).
 * Regroupe les traitements n�cessaire � une session 
 * de consultation / achat d'un visiteur.
 * @author Administrateur
 *
 */
public class Facade {
	private Catalogue leCatalogue;
	int positionCourante = -1;
	
	// le panier et la commande �ventuelle
	private Panier panier;
	private Commande cmd;
	
	// le client associ� (�ventuel)
	private Client client;
	
	// constructeur
	public Facade() {
		leCatalogue = Catalogue.getInstance();
	}
	

	/**
	 * Simule une page de visualisation d'un produit
	 * en parcourant le catalogue
	 * @return Une chaine repr�sentant le d�tail du produit
	 */
	public String parcoursCatalogue() {
		positionCourante++;
		if (positionCourante == leCatalogue.getNbProduits()) 
			positionCourante = 0;
		String produitCourant = leCatalogue.getListe().get(positionCourante).toString();
		return produitCourant;
	}
	/**
	 * Simule un ajout au panier du produit couremment examin�.
	 * @param quantite
	 */
	public void ajoutePanier(int quantite) {
		if (panier == null) {	// cr�e le panier lors du premier achat
			panier = new Panier();
		}
		Produit produitCourant = leCatalogue.getListe().get(positionCourante);
		
		panier.ajoutOption(produitCourant,quantite);
	}
	/**
	 * Affiche le contenu du panier
	 * @return Une chaine d�crivant le panier
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
			// cr�ation de la commande
			cmd = new Commande(client, null, new Date(), panier.getTotal());
			// ajout des d�tails de la commande
			for (DetailPanier dp : panier.getOptions()) {
				cmd.ajouteDetailCommande(dp);
			}
		}  // else ?
		return cmd;
	}
	/**
	 * Affiche les donn�es d'une commande et de ses d�tails.
	 * D�l�gue ce travail � la m�thode toString() de Commande
	 * @return La repr�sentation chaine de l'objet commande
	 */
	public String afficheCommande() {
		if (cmd != null) {
			return cmd.toString();
		}
		return null;
	}

	/**
	 * Collecte les informations pour d�finir un nouveau client. 
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
