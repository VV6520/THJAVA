package Tuan8;

import java.util.Scanner;
public class Main_NV {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Chon loai nhan vien:");
            System.out.println("1. Nhan vien san xuat");
            System.out.println("2. Nhan vien van phong");
            System.out.println("0. Thoat");
            System.out.print("Nhap lua chon cua ban: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    NhanVienSanXuat nvSanXuat = new NhanVienSanXuat();
                    nvSanXuat.Nhap();
                    nvSanXuat.Xuat();
                    break;

                case 2:
                    NhanVienVanPhong nvVanPhong = new NhanVienVanPhong();
                    nvVanPhong.Nhap();
                    nvVanPhong.Xuat();
                    break;

                case 0:
                    System.out.println("Thoat chuong trinh.");
                    break;

                default:
                    System.out.println("Lua chon khong hop le. Vui long chon lai.");
            }
        } 
        while (choice != 0);

        scanner.close();
    }
}