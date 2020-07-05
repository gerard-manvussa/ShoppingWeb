package persistance;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Cette classe tente de simuler simplement une DataSource serveur. Cot�
 * serveur, un objet de ce type sera automatiquement disponible et permettra de
 * se connecter � la base sans que le code ne d�pende d'une quelconque
 * configuration : les d�tails en seront encapsul�s dans la DataSource, d�finie
 * soit par un fichier de configuration XML (Tomcat), soit par une console
 * d'administration (Glassfish, WebSphere, WebLogic etc.). Ici ces d�tails sont
 * dans un fichier de configuration (connexion.properties) que tente de charger
 * cette classe lors de son instanciation.
 * 
 * @author JM
 *
 */
public class DataSource {
	Connection cnx;
	// le nom du fichier properties
	private String fichierProperties = "connexion.properties"; // par d�faut
	// donn�es lues depuis le fichier de propri�t�s
	private String urlJDBC;
	private String nomDriver;
	private String uid, pwd;

	public DataSource() {
		Properties proprietes = new Properties();
		InputStream entree = null;
		try {

			entree = getClass().getClassLoader(). // retrouve le classloader qui a charg� la classe courante
					getResourceAsStream(fichierProperties); // on lui demande de charger �galement le fichier
															// .properties
			proprietes.load(entree); // retrouve les propri�t�s � partir du stream
			urlJDBC = proprietes.getProperty("url-jdbc");
			nomDriver = proprietes.getProperty("driver");
			uid = proprietes.getProperty("uid");
			pwd = proprietes.getProperty("pwd");

			// pour v�rifier qu'on peut les lire
			// System.out.println(urlJDBC);
			// System.out.println(nomDriver);
			// System.out.println(uid);
			// System.out.println(pwd);

		} catch (IOException ex) {
			ex.printStackTrace();
		} finally { // tente de fermer le fichier
			if (entree != null) {
				try {
					entree.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	// getters/setters
	public String getFichierProperties() {
		return fichierProperties;
	}

	public void setFichierProperties(String fichierProperties) {
		this.fichierProperties = fichierProperties;
	}

	public String getUrlJDBC() {
		return urlJDBC;
	}

	public String getNomDriver() {
		return nomDriver;
	}

	public String getUid() {
		return uid;
	}

	public String getPwd() {
		return pwd;
	}

	/**
	 * Tente de se connecter � la base.
	 * Laisse se propager les exceptions.
	 * @return La connexion si elle est �tablie, null dans le cas contraire.
	 */
	public Connection getConnexion() throws Exception {	// laisse se propager les exceptions
		if (cnx == null) {
			Class.forName(nomDriver);
			cnx = DriverManager.getConnection(urlJDBC, uid, pwd);
		}
		return cnx;
	}

	/**
	 * Tente de se d�connecter de la base.
	 */
	public void closeConnexion() {
		try {
		if ((cnx != null) && (!cnx.isClosed())) {
			cnx.close();
		}} catch (SQLException sqle) {}
	}
}
