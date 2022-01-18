package TULIPKU;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private List<Pelanggan> daftarPelanggan = new ArrayList<Pelanggan>();
    private List<Kurir> daftarKurir = new ArrayList<Kurir>();
    private List<Pesanan> daftarPesanan = new ArrayList<Pesanan>();
    private Scanner scanner = new Scanner(System.in);
    final String baru = "Baru";
    final String process = "Sedang Diproses";
    final String finish = "Selesai";
    final String kembali = "Tidak Ditemukan";

    public void addPelanggan(String nama, long no_telp, String alamat_pelanggan, long id_pelanggan, String username,String password)throws IOException {
        Pelanggan tmp_pelanggan = new Pelanggan(nama, no_telp, alamat_pelanggan, id_pelanggan, username, password);
        daftarPelanggan.add(tmp_pelanggan);
    }

    public void addKurir(String nama, long no_telp, long id_kurir, String username, String password)throws IOException{
        Kurir tmp_kurir = new Kurir(nama, no_telp, id_kurir, username, password);
        daftarKurir.add(tmp_kurir);
    }

    public Kurir getkurir(long idKurir){
        int panjang = daftarKurir.size();
        for (int i = 0; i < panjang; i++) {
            if (daftarKurir.get(i).getId_kurir() == idKurir){
                return daftarKurir.get(i);
            }
        }
        return null;
    }

    public Pesanan getPesanan(long idPesanan){
        int panjang = daftarPesanan.size();
        for (int i = 0; i < panjang; i++) {
            if (daftarPesanan.get(i).getId_pesanan() == idPesanan){
                return daftarPesanan.get(i);
            }
        }
        return null;
    }

    public Kurir getKurir(String username, String password){
        int panjang = daftarKurir.size();
        for (int i = 0; i < panjang; i++) {
            if ((username.equals(daftarKurir.get(i).getUsername()))&&(password.equals(daftarKurir.get(i).getPassword()))){
                return daftarKurir.get(i);
            }
        }
        return null;
    }

    public void deleteKurir(long idKurir){
        int panjang = daftarKurir.size();
        for (int i = 0; i < panjang; i++) {
            if (daftarKurir.get(i).getId_kurir() == idKurir){
                daftarKurir.remove(i);
            }
        }
    }

    public Pelanggan getPelanggan(long idPelanggan){
        int panjang = daftarPelanggan.size();
        for (int i = 0; i < panjang; i++) {
            if (daftarPelanggan.get(i).getId_pelanggan() == idPelanggan){
                return daftarPelanggan.get(i);
            }
        }
        return null;
    }

    public Pelanggan getPelanggan(String username,String password){
        int panjang = daftarPelanggan.size();
        for (int i = 0; i < panjang; i++) {
            if((username.equals(daftarPelanggan.get(i).getUsername()))&&(password.equals(daftarPelanggan.get(i).getPassword()))){
                return daftarPelanggan.get(i);
            }
        }
        return null;
    }

    public void deletePelanggan(long idPelanggan){
        int panjang = daftarPelanggan.size();
        for (int i = 0; i < panjang; i++) {
            if (daftarPelanggan.get(i).getId_pelanggan() == idPelanggan){
                daftarPelanggan.remove(i);
            }
        }
    }

    public boolean cekPelanggan(String username, String password){
        if (getPelanggan(username, password) != null){
            return true;
        }
        return false;
    }

    public boolean cekKurir(String username, String password){
        if (getKurir(username, password) != null){
            return true;
        }
        return false;
    }

    public void MenuLayananPemesananTulip(Pelanggan p){
        long id_pesanan;
        String status, alamat_tujuan;
        Pesanan tmpPesanan;
        int indKurir = -1;

        System.out.print("ID Pesanan : ");
        id_pesanan = scanner.nextLong();
        System.out.print("Alamat Tujuan : ");
        alamat_tujuan = scanner.next();



        tmpPesanan = new Pesanan(alamat_tujuan, baru, id_pesanan);
        p.create_Pesanan(tmpPesanan);

        daftarPesanan.add(tmpPesanan);
    }

    public void MenuLayananAntarBarang(Pelanggan p){
        long id_pesanan;
        String status, alamat_tujuan, Barang;
        PetaniBunga tmpPetaniBunga;
        int indKurir = -1;
        /* Scanner input = new Scanner(System.in); */

        System.out.print("ID Pesanan : ");
        id_pesanan = scanner.nextLong();
        System.out.print("Alamat tujuan : ");
        alamat_tujuan = scanner.next();
        System.out.print("Nama Barang : ");
        Barang = scanner.next();

        /** if (Barang == "1"){
         System.out.println("Tulip ");
         }
         else if (Barang == "2"){
         System.out.println("item 2");
         }
         else if (Barang == "Tulip3"){
         System.out.println("item 3");
         }
         else if (Barang == "Tulip4"){
         System.out.println("item 4");
         }
         else {
         System.out.println("Maaf, Format Barang tidak sesuai");
         }

         switch (Barang){
         case "1":
         System.out.println("Tulip");
         break;
         case "2" :
         System.out.println("Tulip2");
         break;
         case "3":
         System.out.println("Tulip3");
         break;
         case "4":
         System.out.println("Tulip4");
         break;
         default:
         System.out.println("Maaf, Format Barang tidak sesuai");
         }  **/

        tmpPetaniBunga = new PetaniBunga(alamat_tujuan, baru, Barang, id_pesanan);
        p.create_Pesanan(tmpPetaniBunga);

        daftarPesanan.add(tmpPetaniBunga);
    }

    public void tambahPelanggan() throws Exception{
        String nama,alamat_pelanggan, username,password;
        long no_telp,id_pelanggan;

        System.out.print("Id Pelanggan : ");
        id_pelanggan = scanner.nextLong();
        System.out.print("Nama : ");
        nama = scanner.next();
        System.out.print("Username : ");
        username = scanner.next();
        System.out.print("Password : ");
        password = scanner.next();
        System.out.print("No Telepon : ");
        no_telp = scanner.nextLong();
        System.out.print("Alamat Pelanggan : ");
        alamat_pelanggan = scanner.next();


        addPelanggan(nama, no_telp, alamat_pelanggan, id_pelanggan, username, password);
    }


    public void tambahKurir() throws Exception{
        String nama,username,password;
        long no_telp,id_kurir;

        System.out.print("Id Kurir : ");
        id_kurir = scanner.nextLong();
        System.out.print("Nama : ");
        nama = scanner.next();
        System.out.print("Username : ");
        username = scanner.next();
        System.out.print("Password : ");
        password = scanner.next();
        System.out.print("No Telepon : ");
        no_telp = scanner.nextLong();

        addKurir(nama, no_telp, id_kurir, username, password);
    }

    public void lihatStatusPesanan(Pelanggan p){
        int banyakPesanan;
        banyakPesanan = p.getjml_pesanan();

        System.out.println("Status Pesanan anda");

        for (int i = 0; i < banyakPesanan; i++) {
            System.out.println("Pesanan ber-id "+p.getPesanan(i).getId_pesanan()+" memiliki status "+p.getPesanan(i).getStatus());
        }
    }

    public void pilihKurir(int florist){
        System.out.println("Silahkan pilih kurir : ");
        for (int i = 0; i < 10; i++) {
            System.out.println((i+1)+". "+daftarKurir.get(i).getNama());
        }
        System.out.print("Pilih Kurir : ");
        florist= scanner.nextInt();
        florist--;
    }

    public void ubahStatusPesanan(Kurir p,Pesanan an){
        String stat;

        System.out.println("Anda sedang membawa pesanan "+an.getId_pesanan());
        System.out.println("Silahkan pilih status yang ingin diubah : ");
        System.out.println("1. Selesai");
        System.out.println("2. Dikembalikan");
        System.out.print("Pilih status : ");
        stat = scanner.next();

        if (new String("1").contains(stat)) {
            an.setStatus(finish);
            an = null;
        }else if(new String("2").contains(stat)){
            an.setStatus(kembali);
            an = null;
        }else{
            System.out.println("inputan salah");
        }
    }

    public void pilihPesanan(Kurir p){
        long tempID;
        int tmpPes = daftarPesanan.size();
        System.out.println("Silahkan pilih pesanan");
        for (int i = 0; i < tmpPes; i++) {
            if(new String(baru).equals(daftarPesanan.get(i).getStatus())){
                System.out.println("ID Pesanan : "+daftarPesanan.get(i).getId_pesanan());
                System.out.println("Alamat Tujuan  :"+daftarPesanan.get(i).getAlamat_tujuan());
                System.out.println("");
            }
        }
    }

    public Pesanan pilihPesanan(Kurir p,long tempID){
        if(getPesanan(tempID)!= null){
            p.createPesanan(getPesanan(tempID));
            getPesanan(tempID).setStatus(process);
            return getPesanan(tempID);
        }else{
            System.out.println("inputan id pesanan salah");
            return null;
        }
    }

    public void MainMenu() throws Exception{
        boolean jalan = true;
        boolean jl = true;
        boolean kurir,pelanggan;
        String username,password;
        String menu;
        Pelanggan tmpPelanggan;
        Kurir tmpKurir;
        Pesanan tmpPesanan = null;
        long jon;

        while(jalan){

            System.out.println("Selamat Datang di Aplikasi TULIPKU");
            System.out.println("1. Login");
            System.out.println("2. Daftar");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu :");
            menu = scanner.next();

            if(new String("1").contains(menu)){
                System.out.println("1. Pelanggan");
                System.out.println("2. Kurir");
                System.out.print("Pilih menu :");
                menu = scanner.next();

                if(new String("1").contains(menu)){
                    //BAGIAN PELANGGAN
                    System.out.println("Silahkan login");
                    System.out.print("Username : ");
                    username = scanner.next();
                    System.out.print("Password : ");
                    password = scanner.next();

                    //cek di pelanggan
                    System.out.println(username +""+password);
                    pelanggan = cekPelanggan(username, password);
                    System.out.println(pelanggan);

                    if(pelanggan){
                        while(jl){
                            //tampung pelanggan
                            tmpPelanggan = getPelanggan(username, password);

                            System.out.println("Silahkan pilih menu");
                            System.out.println("1. Pilih Layanan Antar Barang");
                            System.out.println("2. Lihat Status");
                            System.out.println("3. Logout");
                            System.out.print("Pilih menu :");
                            menu = scanner.next();

                            if(new String("1").contains(menu)){
                                System.out.println("Pilih layanan");
                                System.out.println("1. Lihat Pesanan");
                                System.out.println("2. Antar Barang");
                                System.out.print("Pilih menu :");
                                menu = scanner.next();

                                if(new String("1").contains(menu)){
                                    MenuLayananPemesananTulip(tmpPelanggan);
                                }else if(new String("2").contains(menu)){
                                    MenuLayananAntarBarang(tmpPelanggan);
                                }else{
                                    System.out.println("Menu yang anda inputkan salah");
                                }
                            }else if(new String("2").contains(menu)){
                                lihatStatusPesanan(tmpPelanggan);
                            }else if(new String("3").contains(menu)){
                                pelanggan = false;
                                jl = false;
                            }else{
                                System.out.println("Menu yang anda inputkan salah");
                            }
                        }
                    }
                }else if(new String("2").contains(menu)){
                    //BAGIAN KURIR
                    System.out.println("Silahkan login");
                    System.out.print("Username : ");
                    username = scanner.next();
                    System.out.print("Password : ");
                    password = scanner.next();

                    //cek di Kurir
                    kurir = cekKurir(username, password);
                    if(kurir){
                        while(jl){
                            //tampung Kurir
                            tmpKurir= getKurir(username, password);

                            System.out.println("Silahkan pilih menu");
                            System.out.println("1. Pilih Pesanan");
                            System.out.println("2. Ubah Status Pesanan");
                            System.out.println("3. Logout");
                            System.out.print("Pilih menu :");
                            menu = scanner.next();
                            if(new String("1").contains(menu)){
                                pilihPesanan(tmpKurir);
                                System.out.print("silahkan ketik ID pesanan : ");
                                jon = scanner.nextLong();
                                tmpPesanan = pilihPesanan(tmpKurir, jon);
                                System.out.println(tmpPesanan.getAlamat_tujuan());
                            }else if(new String("2").contains(menu)){
                                ubahStatusPesanan(tmpKurir, tmpPesanan);
                            }else if(new String("3").contains(menu)){
                                kurir = false;
                                jl = false;
                            }else{
                                System.out.println("Menu yang anda inputkan salah");
                            }
                        }
                    }else{
                        System.out.println("Username dan Password salah");
                    }
                }else{
                    System.out.println("Menu yang anda inputkan salah");
                }
            }else if(new String("2").contains(menu)){
                //menu tambah user
                System.out.println("1. Pelanggan");
                System.out.println("2. Kurir");
                System.out.print("Pilih menu :");
                menu = scanner.next();

                if(new String("1").contains(menu)){
                    tambahPelanggan();
                }else if(new String("2").contains(menu)){
                    tambahKurir();
                }else{
                    System.out.println("Menu yang anda inputkan salah");
                }
            }else if(new String("3").contains(menu)){
                jalan = false;
            }else{
                System.out.println("Menu yang anda inputkan salah");
            }
            jl = true;
        }
    }
}
