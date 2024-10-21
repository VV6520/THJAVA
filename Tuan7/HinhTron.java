package Tuan7;

import java.util.Scanner;
public class HinhTron {
    private double banKinh;
    private Scanner scanner = new Scanner(System.in);

    public HinhTron() {
        
    }

    public HinhTron(double banKinh) {
        setBanKinh(banKinh);
    }

    public double getBanKinh() {
        return this.banKinh;
    }

    public void Nhap() {
        do {
            System.out.print("Nhap ban kinh: ");
            double R = scanner.nextDouble();
            if (R > 0) {
                this.banKinh = R;
            } 
            else
                System.out.println("Ban kinh phai lon hon 0. Vui long nhap lai. ");
        } 
        while (this.banKinh <= 0);
    }

    public double tinhChuVi() {
        return 2 * Math.PI * this.banKinh;
    }

    public double tinhDienTich() {
        return Math.PI * this.banKinh * this.banKinh;
    }

    public void Xuat() {
        System.out.println("Ban kinh hinh tron: " + this.banKinh);
        System.out.println("Chu Vi: " + tinhChuVi());
        System.out.println("Dien Tich: " + tinhDienTich());
    }
}