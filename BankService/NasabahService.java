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
    public void addVirtualAcc(int no) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/example", "postgres", "postgres")) {
            Statement statement = connection.createStatement();
            String generatedString = RandomStringUtils.random(9, true, true);
            statement.executeUpdate("INSERT INTO virtual VALUES (" + no +", '" + generatedString +"');");
        }
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
}
