package etape6.metier;

import java.io.Serializable;

/**
 * Représente un produit :
 * <ul>
 * <li>Tel que présenté dans le catalogue.</li>
 * <li>Associé au DetailPanier.</li>
 * <li>Associé au DetailCommande.</li>
 * </ul>
 * @author Administrateur
 *
 */
public class Produit implements Serializable {
	private int code;
	private String nom;
	private String description;
	private double prix;
	private String urlImage;
	
	// constructeur(s)
	public Produit(int code, String nom, String description, double prix, String urlImage) {
		this.code = code;
		this.nom = nom;
		this.description = description;
		this.prix = prix;
		this.urlImage = urlImage;
	}
	// accesseurs

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String getUrlImage() {
		return urlImage;
	}

	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

	@Override
	public String toString() {
		return "Produit [code=" + code + ", nom=" + nom + ", description=" + description + ", prix=" + prix
				+ ", urlImage=" + urlImage + "]";
	}
	
}
