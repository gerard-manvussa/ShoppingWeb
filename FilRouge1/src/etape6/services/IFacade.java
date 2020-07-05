package etape6.services;

import etape6.metier.Client;
import etape6.metier.Commande;
import etape6.metier.Panier;
import etape6.metier.Produit;

public interface IFacade {

	/////////////////////////// Catalogue ////////////////////
	/**
	 * Retourne le produit situé à une position passée en paramètre dans le
	 * catalogue
	 * 
	 * @param positionCourante (manipulée par la logique de navigation)
	 * @return le produit concerné
	 */
	Produit getProduit(int positionCourante);

	/**
	 * Retourne le nombre de produits au catalogue
	 * 
	 * @return le nombre de produits au catalogue
	 */
	int getNbProduits();

	
	///////////////////////// Panier //////////////////////////////
	/**
	 * Ajout au panier du produit couremment examiné.
	 * 
	 * @param positionCourante
	 * @param quantite
	 */
	void ajoutePanier(int positionCourante, int quantite);

	// accesseurs
	Panier getPanier();
	void setPanier(Panier panier);

	/**
	 * Collecte les informations pour définir un nouveau client.
	 * 
	 * @param prenom  Le prenom du client
	 * @param nom     Le nom du client
	 * @param adresse L'adresse du client
	 */
	Client creeClient(String prenom, String nom, String adresse);

	/**
	 * Passe commande en transformant le panier en une commande.
	 * 
	 * @return
	 */
	Commande passeCommande();

	/**
	 * Affiche les données d'une commande et de ses détails. Délègue ce travail à la
	 * méthode toString() de Commande
	 * 
	 * @return La représentation chaine de l'objet commande
	 */
	String afficheCommande();

}