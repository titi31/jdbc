
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
public class Test {
	private static ArrayList<Article> articles = new ArrayList<Article>();
	// private static Properties properties = new Properties();

	//private static InputStream input = null;
	public static void main(final String[] args) {
		final Properties properties = new Properties();
		InputStream input = null;
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("Driver O.K.");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/Shop", "root", "darkorbitdu32");
			Statement state = conn.createStatement();
			ResultSet result = state.executeQuery("SELECT * FROM T_Articles;");
			ResultSet creeBank= state.executeQuery("create database if not exists Bank ;");
			ResultSetMetaData resulBank=creeBank.getMetaData();
			System.out.println("bdd Bank crée avec succès");
			ResultSetMetaData resultMeta = result.getMetaData();
			System.out.println("Connexion effective !");

			int i = 0;
			while (result.next()) {
				i++;
				Article article = new Article(result.getInt(1), result.getString("Description"),
						result.getString("Brand"), result.getInt(4));

				articles.add(article);

			}

			result.close();

			state.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

		displayList(articles);
	

	}

	public static void displayList(ArrayList<Article> tab) {
		// affich ta liste
		System.out.println("+-----------+------------------------+------------------------------+----------------+");
		System.out.println("| IdArticle |   Description          |        Brand        	    | UnitaryPrice   |");
		System.out.println("+-----------+------------------------+------------------------------+----------------+");
		for (int i = 0; i < tab.size(); i++) {
			int mul = 24 - tab.get(i).getDescription().length();
			int arti = 11 - String.valueOf(tab.get(i).getIdArticle()).length();
			int br = 30 - tab.get(i).getBrand().length();
			int pri = 16 - String.valueOf(tab.get(i).getUnitaryPrice()).length();
			List<String> prix = Collections.nCopies(pri, " ");
			List<String> bra = Collections.nCopies(br, " ");
			List<String> artic = Collections.nCopies(arti, " ");
			List<String> tb = Collections.nCopies(mul, " ");
			System.out.println("|" + tab.get(i).getIdArticle() + String.join("", artic) + "|"
					+ tab.get(i).getDescription() + String.join("", tb) + "|" + tab.get(i).getBrand()
					+ String.join("", bra) + "|" + tab.get(i).getUnitaryPrice() + String.join("", prix) + "|");

		}
		System.out.println("+-----------+------------------------+------------------------------+----------------+\n");
	}
	

}
