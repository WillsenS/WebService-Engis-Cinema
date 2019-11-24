package BankService;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.apache.commons.lang3.RandomStringUtils;
import javax.jws.WebService;
import BankDomain.Nasabah;

@WebService
public class NasabahService {
    public boolean isTransactionExist(int dest, long jumlah, String start, String finish) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/WebServiceBank", "postgres", "")) {
            Statement statement = connection.createStatement();
            String Query= "SELECT * FROM txn WHERE time BETWEEN '" + start + "' AND '" + finish +"';";
            ResultSet resultset = statement.executeQuery(Query);
            if (resultset.next() == false) {
                return false;
            } else {
                return true;
            }
            
        }
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
        return false;
    }
}
