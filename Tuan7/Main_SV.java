package Tuan7;

import java.util.Scanner;
public class Main_SV {
    public static void main(String[] args) {
        System.out.printf("Ma sinh vien: ");
        String mSV = new Scanner(System.in).nextLine();
        System.out.printf("Ho va ten: ");
        String ten = new Scanner(System.in).nextLine();
        System.out.printf("Ngay sinh: ");
        String ngaySinh = new Scanner(System.in).nextLine();
        System.out.printf("Diem trung binh: ");
        double diemTB = new Scanner(System.in).nextDouble();
        SinhVien sv = new SinhVien(mSV, ten, ngaySinh, diemTB);
        sv.xeploai();
    }
}
