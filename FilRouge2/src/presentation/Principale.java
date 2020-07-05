package presentation;

import service.Facade;

public class Principale {

	public static void main(String[] args) {
		Facade f = new Facade();
		// affichage produit
		System.out.println(f.parcoursCatalogue());	// premier produit
		System.out.println(f.parcoursCatalogue());	// produit suivant
		f.ajoutePanier(2);							// bon produit
		System.out.println(f.parcoursCatalogue());	// produit suivant
		f.ajoutePanier(4);  						// bon produit
		System.out.println(f.parcoursCatalogue());	// produit suivant
		System.out.println(f.parcoursCatalogue());
		System.out.println(f.parcoursCatalogue());
		f.ajoutePanier(2);							// re-bon produit
		System.out.println(f.affichePanier());		// affichage panier
		
		// C'est le moment de la commande !
		f.saisieInfosClient("John", "De Jonette", "Marne la coquette");
		f.passeCommande(); // pas enregistré
		System.out.println(f.afficheCommande());
	}

}
