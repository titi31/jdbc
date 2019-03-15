import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class TestBank {

	public static void main(String[] args) {

		try {

			PreparedStatement prepare = BankConnection.getInstance().prepareStatement("select * from T_Clients ;");
			Statement state = BankConnection.getInstance().createStatement();
			BankConnection.getInstance().setAutoCommit(false);
			DatabaseMetaData meta = BankConnection.getInstance().getMetaData();

			ResultSet resul = state.executeQuery("select * from T_Clients ;");
			ResultSetMetaData resulBank = resul.getMetaData();
			System.out.println("bdd Bank connecter ");
			int i = 0;
			while (resul.next()) {
				i++;
				System.out.println(resul.getInt(1) + " " + resul.getString(2) + " " + resul.getString(3));

			}

			resul.close();

			state.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
