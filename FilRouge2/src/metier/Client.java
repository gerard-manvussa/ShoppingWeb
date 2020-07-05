package metier;

import java.util.ArrayList;
import java.util.List;

public class Client {
	private Integer code;
	private String nom;
	private String prenom;
	private String adresse;
	private List<Commande> commandes;  // peut être une map ?
	
	// constructeur
	public Client(String nom, String prenom, String adresse) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		commandes =  new ArrayList<Commande>();
	}
	// accesseurs

	public int getCode() {
		return code;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public List<Commande> getCommandes() {
		return commandes;
	}
	public String getAdresse() {
		return adresse;
	}

	@Override
	public String toString() {
		return "Client [code=" + code + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}
	
	
}
