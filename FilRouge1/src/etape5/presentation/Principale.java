package etape5.presentation;

import java.util.Date;

import etape5.metier.DetailCommande;
import etape5.metier.Catalogue;
import etape5.metier.Client;
import etape5.metier.Commande;
import etape5.metier.DetailPanier;
import etape5.metier.Panier;
import etape5.metier.Produit;

public class Principale {
	/**
	 * Simule grossi�rement un parcourt du catalogue par un utilisateur. Il va :
	 * - obtenir un acc�s au catalogue.
	 * - en parcourir chacun des produits
	 * - arbitrairement mettre les produits de rang 2 et 3 dans le panier (2 de chaque !)
	 * - puis d�cider de les commander en donnant ses coordonn�es et cr�ant une commande.
	 * 
	 * Ceci permet de v�rifier sans application web que nos classes m�tier sont bien utilisables
	 * '� minima'.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// obtient un catalogue
		Catalogue c = Catalogue.getInstance();
		// combien de produits au catalogue ?
		int nbProduits = c.getNbProduits();
		// on a besoin d'un panier pour y mettre les choix de l'utilisateur
		Panier panier = new Panier();
		// boucle de parcourt du catalogue
		for (int position = 0; position < nbProduits; position++) {
			// retrouve le produit qui est � cette position dans le catalogue
			Produit p = c.getListe().get(position);
			// affiche ce produit
			System.out.println("Produit en position : " + position + ", " + p);
			// d�cide de mettre les produits en position 2 et 3 dans le panier 
			// avec une quantit� de 2 
			if (position == 2 || position ==3) {
				panier.ajoutOption(p, 2);
			}
		}
		// affichage du panier
		System.out.println(panier); // appel de toString()

        // C'est le moment de la commande
		// On cr�e d'abord un client (on peut le saisir via un Scanner...)
		Client client = new Client("Lastagiaire", "No�mie", "26 rue de la Tuilerie - 37750 - St Avertin");
		Commande commande = new Commande(client,null,new Date(), panier.getTotal());
		// chaque DetailPanier est transform� en DetailCommande dans cette boucle
		for (DetailPanier dp:panier.getOptions()) {
			commande.ajouteDetailCommande(dp);
		}
		// V�rification : on imprime le client et la commande
		System.out.println("Client : " + client);
		System.out.println("Commande : " + commande);
	}

}
