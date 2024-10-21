package Tuan8_3;

public class TaiLieu {
    private String maTaiLieu;
    private String tenTaiLieu;
    private int namXuatBan;
    public TaiLieu(String maTaiLieu, String tenTaiLieu, int namXuatBan){
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.namXuatBan = namXuatBan;
    }
    @Override
    public String toString() {
        return "Mã tài liệu: "+ maTaiLieu
                + "\nTên: "+ tenTaiLieu
                +"\nNăm xuất bản: "+namXuatBan;
    }
}
