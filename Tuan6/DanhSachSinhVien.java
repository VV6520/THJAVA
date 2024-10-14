package Tuan6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class DanhSachSinhVien {
    private ArrayList<SinhVien> danhsach;

    public DanhSachSinhVien() {
        this.danhsach = new ArrayList<>();
    }

    public DanhSachSinhVien(ArrayList<SinhVien> danhsach) {
        this.danhsach = danhsach;
    }

    // 1. Thêm sinh viên vào danh sách
    public void themSinhVien(SinhVien sv) {
        this.danhsach.add(sv);
    }

    // 2. In danh sách sinh viên ra màn hình
    public void inDanhSachSinhVien() {
        for (SinhVien sinhVien : danhsach) {
            System.out.println(sinhVien);
        }
    }

    // 7. Xóa sinh viên ra khỏi danh sách
    public boolean xoaSinhVien(SinhVien sv) {
        return this.danhsach.remove(sv);
    }

    // 8. Tìm sinh viên
    public void timSinhVien(String msv) {
        boolean found = false;
        for (SinhVien sinhVien : danhsach) {
            if (sinhVien.getMaSV().equals(msv)) {
                System.out.println(sinhVien);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Không tìm thấy sinh viên với mã: " + msv);
        }
    }

    // 9. Xuất ra danh sách sinh viên có điểm từ cao đến thấp
    public void sapXepDiemGiamDan() {
        Collections.sort(this.danhsach, new Comparator<SinhVien>() {
            @Override
            public int compare(SinhVien sv1, SinhVien sv2) {
                return Float.compare(sv2.getDiem(), sv1.getDiem());
            }
        });
    }
}