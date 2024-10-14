package Tuan5;
import java.util.ArrayList;

public class SinhVien {
    private String masv;
    private String ten;
    private double dtb;
    private static ArrayList<SinhVien> danhSachSinhVien = new ArrayList<>();

    // Constructor
    public SinhVien(String masv, String ten, double dtb) {
        this.masv = masv;
        this.ten = ten;
        setDtb(dtb);
    }

    public String getMasv() {
        return this.masv;
    }

    public String getTen() {
        return this.ten;
    }

    public double getDtb() {
        return this.dtb;
    }

    public void setDtb(double dtb) {
        if (dtb >= 0 && dtb <= 10) {
            this.dtb = dtb;
        } else {
            System.out.println("Loi: Diem phai tu 0 den 10.");
        }
    }

    public static void themSinhVien(String maSinhVien, String ten, double diemTrungBinh) {
        SinhVien sinhVien = new SinhVien(maSinhVien, ten, diemTrungBinh);
        danhSachSinhVien.add(sinhVien);
        System.out.println("Da them sinh vien: " + sinhVien);
    }

    public static void xoaSinhVien(String maSinhVien) {
        SinhVien sinhVienCanXoa = timSinhVien(maSinhVien);
        if (sinhVienCanXoa != null) {
            danhSachSinhVien.remove(sinhVienCanXoa);
            System.out.println("Da xoa sinh vien: " + sinhVienCanXoa);
        } else {
            System.out.println("Khong tim thay sinh vien voi ma: " + maSinhVien);
        }
    }

    public static SinhVien timSinhVien(String maSinhVien) {
        for (SinhVien sinhVien : danhSachSinhVien) {
            if (sinhVien.getMasv().equals(maSinhVien)) {
                return sinhVien;
            }
        }
        return null;
    }

    public static void sapXepSinhVien() {
        int n = danhSachSinhVien.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (danhSachSinhVien.get(j).getDtb() < danhSachSinhVien.get(j + 1).getDtb()) {
                    // Hoán đổi sinh viên
                    SinhVien temp = danhSachSinhVien.get(j);
                    danhSachSinhVien.set(j, danhSachSinhVien.get(j + 1));
                    danhSachSinhVien.set(j + 1, temp);
                }
            }
        }
        System.out.println("Danh sach sinh vien da duoc sap xep theo diem trung binh:");
        hienThiDanhSachSinhVien();
    }

    public static void hienThiDanhSachSinhVien() {
        if (danhSachSinhVien.isEmpty()) {
            System.out.println("Danh sach sinh vien hien rong.");
        } else {
            System.out.println("Danh sach sinh vien:");
            for (SinhVien sinhVien : danhSachSinhVien) {
                System.out.println(sinhVien);
            }
        }
    }

    @Override
    public String toString() {
        return "Ma sinh vien: " + masv + ", Ten: " + ten + ", Diem trung binh: " + dtb;
    }
}