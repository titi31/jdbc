import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ClientDAO extends DAO<Client> {
	//private static Client client;
	public ClientDAO(Connection conn) {

		super(conn);

	}

	public boolean create(Client client) {
		//Client client=new Client();
		boolean ok=false;
		try {

			
			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("select * from T_Clients;");
			
			if (result.first()) {
				
					int CodeCli = result.getInt("CodeCli");
	    			PreparedStatement prepare = this	.connect
	                                                    .prepareStatement(
	                                                    	"INSERT INTO T_Clients(CodeCli,nom, prenom) VALUES("+client.getCodeCli()+",?, ?)"
	                                                    );
					prepare.setString(1, client.getNom());
					prepare.setString(2, client.getPrenom());
					prepare.executeUpdate();
					client = this.find(CodeCli);	

			ok=true;}
		} catch (SQLException e) {
			ok=false;
			

		}

		
			return ok;
		

	}

	public boolean delete(Client client) {
		//Client client = new Client();
		boolean ok=false;
		try {
			ResultSet resul = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("select * from T_Clients;");
					while(resul.next()) {
						if(resul.getInt("CodeCli")==client.getCodeCli()) {
					
					this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeUpdate("DELETE FROM T_Clients WHERE CodeCli="+client.getCodeCli());
				
					ok=true;
					
					}
					}
			

		} catch (SQLException e) {
			ok=false;
			//e.printStackTrace();

		}


		return ok;



	}

	public boolean update(Client client) {
	//	Client client = new Client();
		boolean ok=false;
		try {
			ResultSet resul = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("select * from T_Clients;");
					while(resul.next()) {
						if(resul.getInt("CodeCli")==client.getCodeCli()) {
							if(resul.getString("nom").contentEquals(client.getNom()) && resul.getString("prenom").contentEquals(client.getPrenom())) {
								break;
							}
					this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeUpdate("UPDATE T_Clients SET nom='"+client.getNom()+"',prenom='"+client.getPrenom()+"' WHERE CodeCli="+client.getCodeCli()+";");
					client = this.find(client.getCodeCli());
					
					
						ok=true;
					
						}
					}
				
			
		}
		catch(SQLException e) {
			ok=false;
			e.printStackTrace();

		}


		return ok;



	}

	public Client find(int CodeCli) {

		Client client = null;

		try {

			ResultSet result = this.connect.createStatement(

					ResultSet.TYPE_SCROLL_INSENSITIVE,

					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM T_Clients WHERE CodeCli = " + CodeCli);

			if (result.first())

				client = new Client(

						CodeCli,

						result.getString("nom"),

						result.getString("prenom"

								));

		} catch (SQLException e) {

			e.printStackTrace();

		}


		return client;

	}

}
