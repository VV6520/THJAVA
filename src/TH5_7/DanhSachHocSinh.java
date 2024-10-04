package TH5_7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachHocSinh {
    private ArrayList<HocSinh> danhsach;
    public DanhSachHocSinh(){
        this.danhsach = new ArrayList<HocSinh>();
    }
    public DanhSachHocSinh(ArrayList<HocSinh> danhsach){
        this.danhsach = danhsach;
    }
    //1.Thêm sinh vien vào danh sách
    public void themHocSinh(HocSinh hs){
        this.danhsach.add(hs);
    }
    //2.In danh sách hoc sinh ra màn hình
    public void inDanhSachHocSinh(){
        for (HocSinh hocSinh : danhsach){
            System.out.println(hocSinh);
        }
    }
    //7. Xóa học sinh ra khỏi danh sách
    public boolean xoaHocSinh(HocSinh hs){
        return this.danhsach.remove(hs);
    }
    //8. Tìm học sinh
    public void timHocSinh(String msv){
        for (HocSinh hocSinh : danhsach)
            if (hocSinh.getMaSV().indexOf(msv)>=0)
                System.out.println(hocSinh);
    }
    //9. Xuất ra danh sách sinh viên có điểm từ thấp đến cao
    public void saXepDiemGiamDan(){
        Collections.sort(this.danhsach, new Comparator<HocSinh>() {
            @Override
            public int compare(HocSinh sv1, HocSinh sv2) {
                if (sv1.getDiem()<sv2.getDiem())
                    return 1;
                else
                    if (sv1.getDiem()>sv2.getDiem())
                        return -1;
                    else
                        return 0;
            }
        });
    }
}
