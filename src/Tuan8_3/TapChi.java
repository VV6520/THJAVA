package Tuan8_3;

public class TapChi extends TaiLieu{
    public TapChi(String maTaiLieu, String tenTaiLieu, int namXuatBan){
        super(maTaiLieu, tenTaiLieu, namXuatBan);
    }
    public void soPhatHanh(int so){
        System.out.println("Tạp chí có số phát hành là: "+so);
    }
    public void doiTuong(String doiTuong){
        System.out.println("Tạp chí này dành cho: "+doiTuong);
    }
}
