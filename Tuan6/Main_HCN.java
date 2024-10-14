package Tuan6;

import java.util.Scanner;

public class Main_HCN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập chiều dài và chiều rộng từ người dùng
        System.out.print("Nhap chieu dai: ");
        double chieuDai = sc.nextDouble();
        System.out.print("Nhap chieu rong: ");
        double chieuRong = sc.nextDouble();

        // Tạo đối tượng HinhChuNhat
        HinhChuNhat hcn = new HinhChuNhat(chieuDai, chieuRong);

        // In thông tin hình chữ nhật
        hcn.inThongTin();

        sc.close(); // Đóng Scanner
    }
}