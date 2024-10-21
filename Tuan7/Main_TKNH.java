package Tuan7;

import java.util.Scanner;
public class Main_TKNH {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so tai khoan: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhap ten tai khoan: ");
        String chuTaiKhoan = scanner.nextLine();
        System.out.print("Nhap so du ban dau: ");
        double soDu = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        // Tạo đối tượng TaiKhoan
        TaiKhoanNH taiKhoan = new TaiKhoanNH(soTaiKhoan, chuTaiKhoan, soDu, matKhau);

        System.out.println("\n--Thong tin tai khoan--");
        System.out.println("So tai khoan: " + taiKhoan.getSoTaiKhoan());
        System.out.println("Chu tai khoan: " + taiKhoan.getChuTaiKhoan());
        System.out.println("So du: " + taiKhoan.getSoDu() + " VND");
        System.out.println("------------------------");
        
        String matKhauCu;
        String matKhauMoi;
        while (true) {
            System.out.print("Nhap mat khau cu de thay doi: ");
            matKhauCu = scanner.nextLine();
            if (matKhauCu.equals(taiKhoan.getmatKhau())) {
                System.out.print("Nhap mat khau moi: ");
                matKhauMoi = scanner.nextLine();
                if (taiKhoan.doiMatKhau(matKhauCu, matKhauMoi))
                    break;
            } 
            else
                System.out.println("Mat khau cu khong dung. Vui long thu lai.");
        }         
    }
}
