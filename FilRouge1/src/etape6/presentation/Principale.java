package etape6.presentation;

import etape6.metier.Client;
import etape6.metier.Produit;
import etape6.services.Facade;
import etape6.services.IFacade;

public class Principale {
	/**
	 * Simule grossi�rement un parcourt du catalogue par un utilisateur. Il va :
	 * - obtenir un acc�s au catalogue.
	 * - en parcourir chacun des produits
	 * - arbitrairement mettre les produits de rang 2 et 3 dans le panier (2 de chaque !)
	 * - puis d�cider de les commander en donnant ses coordonn�es et cr�ant une commande.
	 * 
	 * Dans cette version ne travaille plus directement avec les classes m�tier mais utilise
	 * une fa�ade, sorte de 'guichet unique' asemblant et orchestrant les classes m�tier.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// obtient une instance de la facade
		IFacade f = new Facade();
		// combien de produits au catalogue ?
		int nbProduits = f.getNbProduits();
		for (int position = 0; position < nbProduits; position++) {
			// retrouve le produit qui est � cette position dans le catalogue
			//Produit p = c.getListe().get(position);
			Produit p = f.getProduit(position);
			// affiche ce produit
			System.out.println("Produit en position : " + position + ", " + p);
			// d�cide de mettre les produits en position 2 et 3 dans le panier 
			// avec une quantit� de 2 
			if (position == 2 || position ==3) {
				f.ajoutePanier(position, 2);
			}
		}
		// affichage du panier
		System.out.println(f.getPanier()); // appel de toString()

        // C'est le moment de la commande
		// On cr�e d'abord un client (on peut le saisir via un Scanner...)
		Client clt = f.creeClient("No�mie", "Lastagiaire", "26 rue de la Tuilerie - 37750 - St Avertin");
		f.passeCommande();  	// tous les d�tails sont cach�s
		
		// V�rification : on imprime le client et la commande
		System.out.println("Client : " + clt);
		System.out.println("Commande : " + f.afficheCommande());
	}

}
