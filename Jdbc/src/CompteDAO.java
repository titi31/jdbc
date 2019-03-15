import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CompteDAO extends DAO<Compte> {

	public CompteDAO(Connection conn) {

		super(conn);

	}
	
	@Override
	public boolean create(Compte compte) {
		boolean ok=false;
		try {

			ResultSet result = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("select * from T_Comptes;");
			
			if (result.first()) {
				
					int CodeCli = result.getInt("CodeCli");
	    			PreparedStatement prepare = this	.connect
	                                                    .prepareStatement(
	                                                    	"INSERT INTO T_Comptes(NumCpte,solde, CodeCli) VALUES(? , ? ,"+compte.getCodeCli()+")"
	                                                    );
					prepare.setInt(1, compte.getNumCpte());
					prepare.setInt(2, compte.getSolde());
					prepare.executeUpdate();
					compte = this.find(CodeCli);

					ok=true;
				}
			
		} catch (SQLException e) {
			ok=false;
			//e.printStackTrace();

		}

		return ok;

	}

	public boolean delete(Compte compte) {


		boolean ok=false;
		try {
			ResultSet resul = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("select * from T_Comptes;");
					while(resul.next()) {
						if(resul.getInt("NumCpte")==compte.getNumCpte()) {
					
					this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeUpdate("DELETE FROM T_Comptes WHERE NumCpte="+compte.getNumCpte());
				
					ok=true;
					
					}
					}
			

		} catch (SQLException e) {
			ok=false;
			//e.printStackTrace();

		}


		return ok;

	}

	@Override
	public boolean update(Compte compte) {

		boolean ok=false;
		try {
			ResultSet resul = this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
					.executeQuery("select * from T_Comptes;");
					while(resul.next()) {
						if(resul.getInt("CodeCli")==compte.getCodeCli()) {
							if(resul.getInt("NumCpte")==compte.getNumCpte() && resul.getInt("solde")==compte.getSolde()) {
								break;
							}
					this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE)
							.executeUpdate("UPDATE T_Comptes SET NumCpte='"+compte.getNumCpte()+"',solde='"+compte.getSolde()+"' WHERE CodeCli="+compte.getCodeCli()+";");
					compte = this.find(compte.getCodeCli());
					
					
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

	public Compte find(int CodeCli) {

		Compte compte = null;

		try {

			ResultSet result = this.connect.createStatement(

					ResultSet.TYPE_SCROLL_INSENSITIVE,

					ResultSet.CONCUR_READ_ONLY).executeQuery("SELECT * FROM T_Comptes WHERE CodeCli = " + CodeCli);

			if (result.first())

				compte = new Compte(result.getInt("NumCpte"), result.getInt("solde"),

						CodeCli

				);

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return compte;

	}

}
