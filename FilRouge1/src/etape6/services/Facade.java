package etape6.services;

import java.util.Date;

import etape6.metier.Catalogue;
import etape6.metier.Client;
import etape6.metier.Commande;
import etape6.metier.DetailPanier;
import etape6.metier.Panier;
import etape6.metier.Produit;

/**
 * Représente la façade applicative (couche de services). Regroupe les
 * traitements nécessaire à une session de consultation / achat d'un visiteur.
 * 
 * @author Administrateur
 *
 */
public class Facade implements IFacade {     				// chaque visiteur du site aura un objet Facade qui lui sera associé
	private Catalogue leCatalogue;

	// le panier et la commande éventuelle
	private Panier panier;
	private Commande cmd;

	// le client associé (éventuel)
	private Client client;

	// constructeur
	public Facade() {
		leCatalogue = Catalogue.getInstance();
	}

/////////////////////////// Catalogue ////////////////////
	/**
	 * Retourne le produit situé à une position passée en paramètre dans le
	 * catalogue
	 * 
	 * @param positionCourante (manipulée par la logique de navigation)
	 * @return le produit concerné
	 */
	@Override
	public Produit getProduit(int positionCourante) {
		if (positionCourante == leCatalogue.getNbProduits())
			positionCourante = 0;
		Produit produitCourant = leCatalogue.getListe().get(positionCourante);
		return produitCourant;
	}

	/**
	 * Retourne le nombre de produits au catalogue
	 * 
	 * @return le nombre de produits au catalogue
	 */
	@Override
	public int getNbProduits() {
		return leCatalogue.getNbProduits();
	}

	/**
	 * Ajout au panier du produit couremment examiné.
	 * 
	 * @param positionCourante
	 * @param quantite
	 */
///////////////////////// Panier //////////////////////////////

	@Override
	public void ajoutePanier(int positionCourante, int quantite) {
	   if (panier == null) { // crée le panier lors du premier achat
		 this.panier =  new Panier();
		 }
		Produit produitCourant = leCatalogue.getListe().get(positionCourante);
		panier.ajoutOption(produitCourant, quantite);
	}

	// accesseurs
	@Override
	public Panier getPanier() {
		return panier;
	}

	@Override
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	
	
	/**
	 * Collecte les informations pour définir un nouveau client.
	 * 
	 * @param prenom  Le prenom du client
	 * @param nom     Le nom du client
	 * @param adresse L'adresse du client
	 */
	@Override
	public Client creeClient(String prenom, String nom, String adresse) {
		if (client == null) {
			client = new Client(nom, prenom, adresse);
		} 
		return this.client;
	}
	/**
	 * Passe commande en transformant le panier en une commande.
	 * 
	 * @return
	 */
	@Override
	public Commande passeCommande() {
		if ((cmd == null) && (client != null)) {
			// création de la commande
			cmd = new Commande(client, null, new Date(), panier.getTotal());
			// ajout des détails de la commande
			for (DetailPanier dp : panier.getOptions()) {
				cmd.ajouteDetailCommande(dp);
			}
		} // else ?
		return cmd;
	}

	/**
	 * Affiche les données d'une commande et de ses détails. Délègue ce travail à la
	 * méthode toString() de Commande
	 * 
	 * @return La représentation chaine de l'objet commande
	 */
	@Override
	public String afficheCommande() {
		if (cmd != null) {
			return cmd.toString();
		}
		return null;
	}



}
