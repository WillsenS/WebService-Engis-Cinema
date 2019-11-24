import bankservice.NasabahService;
import bankservice.NasabahServiceService;
import bankservice.Nasabah;

public class Main {
	public static void main (String[] args) {
		//URL : http://localhost:8080/tesws
		NasabahServiceService n = new NasabahServiceService();
		NasabahService n1 = n.getNasabahServicePort();
		
		//Testcase isRekeningValid
//		SELECT * FROM customer;
//		  name  | acc_num | balance_first | balance_last
//		--------+---------+---------------+--------------
//		 Rickie |       2 |           500 |          385
//		 Cipy   |       6 |            50 |          100
//		 Jaskey |       3 |           100 |          265
//		 Arvin  |       5 |           100 |        10000
		
		System.out.println("Test no rek 5 : " + n1.isNoRekValid(5));
		System.out.println("Test no rek 10 : " + n1.isNoRekValid(10));
		
		//Testcase getNasabahByNoRek
		Nasabah nas = n1.getNasabahByNoRek(6);
		
		System.out.println("Test Search Nasabah No Rek 6 :");
		System.out.println("Nama : " + nas.getNama());
		System.out.println("No rekening : " + nas.getNoRek());
		System.out.println("Saldo : " + nas.getSaldo());
		
		Nasabah nas1 = n1.getNasabahByNoRek(100);
		
		System.out.println("Test Search nasabah No rek 100 : " + nas1);
		
		//Testcase transfer uang
		n1.transferMoney(2, 6, 185);
		
		//testcase check transaksi
		System.out.println(n1.isTransactionExist(6, 185, "2019-04-04", "2021-05-05"));
		
		//testcase add virtual acc
		n1.addVirtualAcc(3);
	}
}
