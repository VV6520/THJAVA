package Tuan8_3;

public class Sach extends TaiLieu{
    public Sach(String maTaiLieu, String tenTaiLieu, int namXuatBan){
        super(maTaiLieu, tenTaiLieu, namXuatBan);
    }
    public void soTrang(int so){
        System.out.println("Sách có "+ so+" trang");
    }
    public void theLoai(String theLoai){
        System.out.println("Sách thuộc thể loại: "+ theLoai);
    }
}
