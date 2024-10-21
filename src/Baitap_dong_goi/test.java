package Baitap_dong_goi;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        System.out.printf("Số tài khoản: ");
        String soTaiKhoan = new Scanner(System.in).nextLine();
        System.out.printf("Chủ tài khoản: ");
        String chuTaiKhoan = new Scanner(System.in).nextLine();
        System.out.printf("Nhập vào số dư ban đầu: ");
        double soDu = new Scanner(System.in).nextDouble();
        System.out.printf("Mật khẩu: ");
        String matKhau = new Scanner(System.in).nextLine();
        TaiKhoan tk = new TaiKhoan(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        int phuongThuc = 0;
        do{
            System.out.println("-----");
            System.out.println("1.Gửi tiền\n" +"2.Rút tiền\n"+"3.Kiểm tra số dư\n"+"4.Đổi mật khẩu\n"+"5.Kiểm tra mật khẩu\n"+"Nhấn 0 để thoát!");
            System.out.printf("Nhập vào phương thức cần thực hiện: ");
            phuongThuc = new Scanner(System.in).nextInt();
            switch (phuongThuc){
                    case 1:
                        System.out.printf("Nhập vào số tiền cần gửi: ");
                        double tienGui = new Scanner(System.in).nextDouble();
                        tk.guiTien(tienGui);
                        break;
                    case 2:
                        System.out.printf("Nhập vào số tiền cần rút: ");
                        double tienRut = new Scanner(System.in).nextDouble();
                        tk.rutTien(tienRut);
                        break;
                    case 3:
                        System.out.println("Số dư hiện tại là: "+ tk.kiemTraSoDu());
                        break;
                    case 4:
                        System.out.println("Nhập vào mật khẩu hiện tại: ");
                        String matKhauCu = new Scanner(System.in).nextLine();
                        tk.kiemTra(matKhauCu);
                        break;
                    case 5:
                        System.out.println("Mật khẩu hiện tại: "+ tk.getMatKhau());
                        break;
        }
    }while (phuongThuc != 0);
    }
}
