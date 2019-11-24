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
    public void addVirtualAcc(int no) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/WebServiceBank", "postgres", "")) {
            Statement statement = connection.createStatement();
            String generatedString = RandomStringUtils.random(9, true, true);
            statement.executeUpdate("INSERT INTO virtual VALUES (" + no +", '" + generatedString +"');");
        }
        catch (SQLException e) {
            System.out.println("Connection failure.");
            e.printStackTrace();
        }
    }
	public boolean isNoRekValid(int no) {
	    try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/WebServiceBank", "postgres", "")) {
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

	public void TransferMoney(int sender, int receiver, long jumlah) {
        if(isNoRekValid(sender) && isNoRekValid(receiver)) {
            try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/WebServiceBank", "postgres", "")) {
                Statement statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO txn(acc_num_src,amount,acc_num_dest) VALUES (" + sender +", " + jumlah +", " + receiver+ ");");
            }
            catch (SQLException e) {
                System.out.println("Connection failure.");
                e.printStackTrace();
            }
        }
        else {
            System.out.println("Nomor rekening tidak ditemukan");
        }
    }

	public Nasabah getNasabahByNoRek(int no) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost/WebServiceBank", "postgres", "")) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM public.customer;");
            while (resultSet.next()) {
                if(no == resultSet.getInt("acc_num")) {
                    return new Nasabah(resultSet.getString("name"), resultSet.getInt("acc_num"), resultSet.getLong("balance_last"));
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
	}
}
