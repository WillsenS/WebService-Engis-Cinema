package BankDomain;

public class Nasabah {
	private String nama;
	private String no_rek;
	private long saldo;
	
	public Nasabah(String nama, String no_rek, long saldo) {
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

	public String getNo_rek() {
		return no_rek;
	}

	public void setNo_rek(String no_rek) {
		this.no_rek = no_rek;
	}

	public long getSaldo() {
		return saldo;
	}

	public void setSaldo(long saldo) {
		this.saldo = saldo;
	}
	
	
}
