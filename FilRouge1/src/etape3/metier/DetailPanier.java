package etape3.metier;
/**
 * Représente un choix de produit fait par le visiteur lors du parcourt
 * du catalogue. Classe non persistante.
 * @author Administrateur
 *
 */
public class DetailPanier {
	private Produit produit;
	private int quantite;
	private double sousTotal;
	
	// constructeur
	public DetailPanier(Produit produit, int quantite, double sousTotal) {
		this.produit = produit;
		this.quantite = quantite;
		this.sousTotal = sousTotal;
	}
	// accesseurs
	public Produit getProduit() {
		return produit;
	}
	public void setProduit(Produit produit) {
		this.produit = produit;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	public double getSousTotal() {
		return sousTotal;
	}
	public void setSousTotal(double sousTotal) {
		this.sousTotal = sousTotal;
	}
	
	@Override
	public String toString() {
		return "DetailPanier [produit=" + produit.getNom() + ", quantite=" + quantite + ", sousTotal=" + sousTotal + "]";
	}
	
}
