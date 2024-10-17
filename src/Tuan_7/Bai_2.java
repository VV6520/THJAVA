package Tuan_7;

import java.util.Scanner;

public class Bai_2 {
    public static void main(String[] args) {
        System.out.printf("Mã sinh viên: ");
        String mSV = new Scanner(System.in).nextLine();
        System.out.printf("Họ và tên: ");
        String ten = new Scanner(System.in).nextLine();
        System.out.printf("Ngày sinh: ");
        String ngaySinh = new Scanner(System.in).nextLine();
        System.out.printf("Điểm trung bình: ");
        double diemTB = new Scanner(System.in).nextDouble();
        SinhVien sv = new SinhVien(mSV, ten, ngaySinh, diemTB);
        sv.xeploai();
    }
}
