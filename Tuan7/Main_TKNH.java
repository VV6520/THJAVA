package Tuan7;
import java.util.Scanner;

public class Main_TKNH {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhap so tai khoan: ");
        String soTaiKhoan = scanner.nextLine();

        System.out.print("Nhap ten chu tai khoan: ");
        String chuTaiKhoan = scanner.nextLine();

        System.out.print("Nhap so du ban dau: ");
        double soDu = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Nhap mat khau: ");
        String matKhau = scanner.nextLine();

        // Tạo đối tượng TaiKhoanNH
        TaiKhoanNH taiKhoan = new TaiKhoanNH(soTaiKhoan, chuTaiKhoan, soDu, matKhau);

        // Hiển thị thông tin tài khoản
        System.out.println("\nThong tin tai khoan:");
        System.out.println("So tai khoan: " + taiKhoan.getSoTaiKhoan());
        System.out.println("Chu tai khoan: " + taiKhoan.getChuTaiKhoan());
        System.out.println("So du: " + taiKhoan.getSoDu() + " VND");

        // Thay đổi mật khẩu
        System.out.print("\nNhap mat khau cu de thay doi: ");
        String matKhauCu = scanner.nextLine();

        System.out.print("Nhap mat khau moi: ");
        String matKhauMoi = scanner.nextLine();
        
        taiKhoan.doiMatKhau(matKhauCu, matKhauMoi);
        
        scanner.close();
    }
}
