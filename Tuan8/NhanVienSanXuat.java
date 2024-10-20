package Tuan8;

import java.util.Scanner;
public class NhanVienSanXuat extends NhanVien {
    private int soSanPham;
    private double giaTriSanPham;

    public NhanVienSanXuat() {
        
    }

    public NhanVienSanXuat(String maNhanVien, String ten, double luongCoBan, int soSanPham, double giaTriSanPham) {
        super(maNhanVien, ten, luongCoBan);
        this.soSanPham = soSanPham;
        this.giaTriSanPham = giaTriSanPham;
    }

    @Override
    public void Nhap() {
        super.Nhap();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so san pham: ");
        soSanPham = scanner.nextInt();
        System.out.print("Nhap gia tri san pham: ");
        giaTriSanPham = scanner.nextDouble();
    }

    @Override
    public void Xuat() {
        super.Xuat();
        System.out.println("So san pham: " + soSanPham);
        System.out.println("Gia tri san pham: " + giaTriSanPham);
        System.out.println("Luong cua nhan vien san xuat: " +tinhLuong());
    }

    @Override
    public double tinhLuong() {
        return getLuongCoBan() + (soSanPham * giaTriSanPham);
    }
}
