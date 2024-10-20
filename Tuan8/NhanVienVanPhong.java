package Tuan8;

import java.util.Scanner;
public class NhanVienVanPhong extends NhanVien {
    private double heSoLuong;

    public NhanVienVanPhong() {
        
    }

    public NhanVienVanPhong(String maNhanVien, String ten, double luongCoBan, double heSoLuong) {
        super(maNhanVien, ten, luongCoBan);
        this.heSoLuong = heSoLuong;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap he so luong: ");
        heSoLuong = scanner.nextDouble();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("He so luong: " + heSoLuong);
        System.out.println("Luong cua nhan vien van phong: " +tinhLuong());
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() * heSoLuong;
    }
}
