package Tuan8_3;

public class Bao extends TaiLieu{
    public Bao(String maTaiLieu, String tenTaiLieu, int namXuatBan){
        super(maTaiLieu, tenTaiLieu, namXuatBan);
    }
    public void chuyenMuc(String chuyenMuc){
        System.out.println("Chuyen muc: "+ chuyenMuc);
    }

}
