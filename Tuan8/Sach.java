package Tuan8;

public class Sach extends TaiLieu{
    public Sach(String maTaiLieu, String tenTaiLieu, int namXuatBan){
        super(maTaiLieu, tenTaiLieu, namXuatBan);
    }
    public void soTrang(int so){
        System.out.println("Sach co "+ so+" trang");
    }
    public void theLoai(String theLoai){
        System.out.println("Sach thuoc the loai: "+ theLoai);
    }
}