package Tuan8;

public class TapChi extends TaiLieu{
    public TapChi(String maTaiLieu, String tenTaiLieu, int namXuatBan){
        super(maTaiLieu, tenTaiLieu, namXuatBan);
    }
    public void soPhatHanh(int so){
        System.out.println("Tap chi co so phat hanh: "+so);
    }
    public void doiTuong(String doiTuong){
        System.out.println("Tap chi danh cho: "+doiTuong);
    }
}
