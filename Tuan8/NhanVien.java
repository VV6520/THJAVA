package Tuan8;
import java.util.Scanner;
public class NhanVien {
    private String maNhanVien;
    private String ten;
    private double luongCoBan;

    public NhanVien() {
        
    }

    public NhanVien(String maNhanVien, String ten, double luongCoBan) {
        this.maNhanVien = maNhanVien;
        this.ten = ten;
        this.luongCoBan = luongCoBan;
    }

    public void Nhap() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ma nhan vien: ");
        maNhanVien = scanner.nextLine();
        System.out.print("Nhap ten nhan vien: ");
        ten = scanner.nextLine();
        System.out.print("Nhap luong co ban: ");
        luongCoBan = scanner.nextDouble();
    }

    public void Xuat() {
        System.out.println("Ma nhan vien: " + maNhanVien);
        System.out.println("Ten nhan vien: " + ten);
        System.out.println("Luong co ban: " + luongCoBan);
    }

    public double getLuongCoBan() {
        return luongCoBan;
    }

    public double tinhLuong() {
        return luongCoBan;
    }
}