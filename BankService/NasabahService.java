package BankService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;

import BankDomain.Nasabah;

@WebService
public class NasabahService {
	
	public Nasabah getNasabahByNoRek(String no) {
		try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.customer");
            while (resultSet.next()) {
                if(no == resultSet.getString("no_rek")) {
                	return new Nasabah(resultSet.getString("nama"), resultSet.getString("no_rek"), resultSet.getLong("saldo"));
                }
            }
            return null;
        } /*catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            e.printStackTrace();
        }*/ catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
		return null;
	}
}
