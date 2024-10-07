package TH6_2;

import TH6_2.SinhVien;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhsach;
    public DanhSachSinhVien(){
        this.danhsach = new ArrayList<SinhVien>();
    }
    public DanhSachSinhVien(ArrayList<SinhVien> danhsach){
        this.danhsach = danhsach;
    }
    //1.Thêm sinh vien vào danh sách
    public void themSinhVien(SinhVien sv){
        this.danhsach.add(sv);
    }
    //2.In danh sách hoc sinh ra màn hình
    public void inDanhSachSinhVien(){
        for (SinhVien sinhVien : danhsach){
            System.out.println(sinhVien);
        }
    }
    //9. Xuất ra danh sách sinh viên có điểm từ thấp đến cao
    public void saXepDiemSvGiamDan(){
        Collections.sort(this.danhsach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
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

