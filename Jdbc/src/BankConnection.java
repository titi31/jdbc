import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BankConnection {
	
	 private static String url="db.url";
	 private static String user="db.user";
	 private static String pass="db.pass";
	 private static Connection connect;
	 private BankConnection()  {
		
		 final Properties properties = new Properties();
		 InputStream input = null;
	
			try {
				 
				input = new FileInputStream("src/config.properties");

				// load a properties file
				properties.load(input);
				
				connect=DriverManager.getConnection(properties.getProperty(url),properties.getProperty(user),properties.getProperty(pass));
			}catch(SQLException e) {
				e.printStackTrace();
			}catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	 public static Connection getInstance(){
			
		    if(connect == null){
		        new BankConnection();
		        //System.out.println("instanciation de la connexion sql !");

		      }

		    else {
		    	System.out.println("connexion sql existante !");
		    }

		    return connect;

		  }   

}
