package Tuan8;

public class TaiLieu {
    protected String maTaiLieu;
    protected String tenTaiLieu;
    protected int namXuatBan;
    public TaiLieu(String maTaiLieu, String tenTaiLieu, int namXuatBan){
        this.maTaiLieu = maTaiLieu;
        this.tenTaiLieu = tenTaiLieu;
        this.namXuatBan = namXuatBan;
    }
    @Override
    public String toString() {
        return "Ma tai lieu: "+ maTaiLieu
                + "\nTen: "+ tenTaiLieu
                +"\nNam xuat ban: "+namXuatBan;
    }
}
