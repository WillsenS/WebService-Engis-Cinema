Implementasi web service Bank di atas java servlet menggunakan JAX-WS dengan protokol SOAP. Web service ini digunakan untuk Aplikasi Bank Pro dan Engima.

Web service Bank memiliki basis data terpisah dari basis data Engima yang terdiri dari:
Data nasabah: nama, nomor rekening, saldo awal, saldo akhir
Virtual: No Rekening, No virtual akun
Transaksi: ID transaksi, No rekening pengirim, jumlah, No rekening penerima, waktu

Layanan yang disediakan oleh web service ini adalah:
-Validasi nomor rekening:
Jika nomor rekening terdaftar di basis data, maka nomor tersebut valid.

-Memberikan data rekening seorang nasabah:
Data pengguna meliputi nama pengguna, nomor kartu nomor rekening, saldo terakhir, dan riwayat transaksi (debit dan kredit).

-Melakukan transaksi transfer:
dengan input nomor rekening pengirim, nomor rekening/akun virtual penerima, dan jumlah uang yang ditransfer. Layanan mengembalikan status transfer (berhasil/gagal). Transfer berhasil jika:
1. Nomor rekening atau akun virtual tujuan valid
2. Saldo rekening mencukupi untuk transaksi
3. Jika transfer berhasil, akan dicatat transaksi debit pada rekening pengirim dan transaksi kredit pada rekening penerima.

-Membuat akun virtual untuk suatu nomor rekening:
Layanan mengembalikan nomor unik akun virtual tersebut.
Mengecek ada atau tidak sebuah transaksi kredit dalam suatu rentang waktu. Input yang diterima adalah nomor rekening atau akun virtual tujuan, jumlah nominal yang diharapkan, dan jangka waktu (dalam menit) rentang waktu (start datetime, end datetime).

Database WS-Bank menggunakan PostgreSQL disambungkan melalui JDBC.

Java yang digunakan : JDK 8