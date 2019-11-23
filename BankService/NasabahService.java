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
	
	public boolean isNoRekValid(int no) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.customer;");
            while (resultSet.next()) {
                if(no == resultSet.getInt("acc_num")) {
                    return true;
                }
            }
            return false;
        }catch (SQLException e) {
                System.out.println("Connection failure.");
                e.printStackTrace();
        }
        return false;
    }
}
