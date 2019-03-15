import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class TestDAO {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		//crétion de l'objet DAO
		ClientDAO clientDao = new ClientDAO(BankConnection.getInstance());
		
		//test unitaire/clientDao sur la méthode create		
		Client client=new Client(24,"bernard","laude");
		if(clientDao.create(client))	
			System.out.println("insertion dans la table des clients !");
		else System.out.println("pb insertion !");
				
		//test unitaire/clientDao la methode find
		Client client1 = clientDao.find(1);
		if (client1 != null)
			System.out.println(client1);
		else
			System.out.println("client inexistant !");
		
		//test unitaire/clientDao sur delete	
		Client client2=new Client(18,"Laude","toto");
		if(clientDao.delete(client2)) {
			System.out.println("supression réussie avec succès");
		}else {
			System.out.println("client inéxistant");
		}
		//test unitaire/clientDao sur update
		Client client3=new Client(14,"tata","toto");
		if(clientDao.update(client3)) {
			System.out.println("mis a jour avec succès");
		}else {
			System.out.println("erreur de mise a jour");
		}
				
		//test unitaire/CompteDao sur find
	CompteDAO compteDao = new CompteDAO(BankConnection.getInstance());
		if(compteDao.find(1) != null) {
			System.out.println(compteDao.find(1));
		}else {
			System.out.println("compte inexistant");
		}
		Compte compte=new Compte(1056,200000,1);
		if(compteDao.create(compte)) {
			System.out.println("insertion dans la table des comptes");
		}else {
			System.out.println("pb insertion");
		}
		//Compte compte1=new Compte(24,20000,4);
		compte.setNumCpte(100);
		if(compteDao.delete(compte)) {
			System.out.println("suppression faite");
		}else {
			System.out.println("numero compte introuvable");
		}
		Compte compte1=new Compte(6,32999,5);
		if(compteDao.update(compte1)) {
			System.out.println("mise ajour reussit");
		}else {
			System.out.println("mise a jour echoué");
		}
		
	}
}
		