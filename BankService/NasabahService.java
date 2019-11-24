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
}
