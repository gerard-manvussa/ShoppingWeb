package persistance;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import metier.Produit;

/**
 * Fournit les services de persistance à la classe Produit.
 * Utilise la classe DataSource chargeant les informations de
 * connexion depuis un fichier .properties.
 * 
 * Pour créer la table, avec MySQL :
 *			CREATE TABLE `test`.`Produits` (
 *				  `code` INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
 *				  `nom` VARCHAR(45) NOT NULL,
 *				  `description` VARCHAR(255),
 *				  `prix` DOUBLE NOT NULL,
 *				  `urlImage` VARCHAR(255),
 *				  PRIMARY KEY (`code`)
 *				)
 *				ENGINE = InnoDB;
 *
 *		Et pour ajouter une ligne (par exemple) :
 *				
 *		INSERT INTO Produits (nom,description,prix) VALUES ('Johnny Halliday','Les 100 plus belles chansons',119.9);
 * 
 * @author JM
 *
 */
public class ProduitDAO {
	DataSource ds;
	Connection cnx;
	
	public ProduitDAO() throws Exception {
		ds = new DataSource();
		cnx = ds.getConnexion();
	}
	
	public List<Produit> chargeProduits() {
		List<Produit> liste = null;
		String sql = "SELECT * from Produits";
		Statement st;
			try {
				st = cnx.createStatement();
				ResultSet rs = st.executeQuery(sql);
				liste = new ArrayList<Produit>();
				Produit p = null;
				while (rs.next()) { // pour chaque ligne, instancie un objet Produit
					p = new Produit(rs.getInt("code"),rs.getString("nom"), rs.getString("description"),
									rs.getDouble("prix"), rs.getString("urlImage"));
					liste.add(p);
				}
			} catch (SQLException e) {	// 'avale' l'exception...
				e.printStackTrace();
			}
			finally {
				// aucune autre opération DAO dans cette classe, ferme la connexion
				ds.closeConnexion();				
			}
		return liste;
	}


}
