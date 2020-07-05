package etape6.services;

import etape6.metier.Client;
import etape6.metier.Commande;
import etape6.metier.Panier;
import etape6.metier.Produit;

public interface IFacade {

	/////////////////////////// Catalogue ////////////////////
	/**
	 * Retourne le produit situ� � une position pass�e en param�tre dans le
	 * catalogue
	 * 
	 * @param positionCourante (manipul�e par la logique de navigation)
	 * @return le produit concern�
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
	 * Ajout au panier du produit couremment examin�.
	 * 
	 * @param positionCourante
	 * @param quantite
	 */
	void ajoutePanier(int positionCourante, int quantite);

	// accesseurs
	Panier getPanier();
	void setPanier(Panier panier);

	/**
	 * Collecte les informations pour d�finir un nouveau client.
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
	 * Affiche les donn�es d'une commande et de ses d�tails. D�l�gue ce travail � la
	 * m�thode toString() de Commande
	 * 
	 * @return La repr�sentation chaine de l'objet commande
	 */
	String afficheCommande();

}