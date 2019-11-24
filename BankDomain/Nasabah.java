package BankDomain;	

public class Nasabah {
	private String nama;
	private int no_rek;
	private long saldo;
	
	public Nasabah(String nama, int no_rek, long saldo) {
		super();
		this.nama = nama;
		this.no_rek = no_rek;
		this.saldo = saldo;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public int getNo_rek() {
		return no_rek;
	}

	public void setNo_rek(int no_rek) {
		this.no_rek = no_rek;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}
	
	
}

