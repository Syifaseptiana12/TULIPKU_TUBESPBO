package TULIPKU;

public abstract class Orang {
    private String nama;
    private long no_telp;
    private String username;
    private String password;

    public String getNama(){
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public long getNo_telp() {
        return no_telp;
    }

    public void setNo_telp(long no_telp){
        this.no_telp = no_telp;
    }

    public String getUsername(){
        return username;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString(){
        String x = "\nNama : "+this.getNama()+"" +
                "\nNo Telp : "+this.getNo_telp();
        return x;
    }

}
