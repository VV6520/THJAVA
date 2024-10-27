package Baitap_dong_goi_2;

import java.util.Scanner;
//Nguyễn Hữu Phước - 23115053122132
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
            System.out.println("1.Gửi tiền\n" +"2.Rút tiền\n"+"3.Kiểm tra số dư\n"+"4.Đổi mật khẩu\n"+"5.Gửi tiền tiết kiệm\n"+"6.Kiểm tra mật khẩu\n"+"7. Chuyển tiền\n"+"Nhấn 0 để thoát!");
            System.out.printf("Nhập vào phương thức cần thực hiện: ");
            phuongThuc = new Scanner(System.in).nextInt();
            switch (phuongThuc){
                    case 1:
                        System.out.printf("Mời nhập mật khẩu: ");
                        String checkMK = new Scanner(System.in).nextLine();
                        System.out.printf("Nhập vào số tiền cần gửi: ");
                        double tienGui = new Scanner(System.in).nextDouble();
                        tk.guiTien(tienGui, checkMK);
                        break;
                    case 2:
                        System.out.printf("Mời nhâp mật khẩu: ");
                        String xacNhanMK = new Scanner(System.in).nextLine();
                        System.out.printf("Nhập vào số tiền cần rút: ");
                        double tienRut = new Scanner(System.in).nextDouble();
                        tk.rutTien(tienRut, xacNhanMK);
                        break;
                    case 3:
                        System.out.println("Số dư hiện tại là: "+ tk.kiemTraSoDu());
                        break;
                    case 4:
                        System.out.printf("Nhập vào mật khẩu hiện tại: ");
                        String matKhauCu = new Scanner(System.in).nextLine();
                        tk.kiemTra(matKhauCu);
                        break;
                    case 5:
                        System.out.printf("Nhập vào mật khẩu hiện tại: ");
                        String matKhauHT = new Scanner(System.in).nextLine();
                        System.out.printf("Nhập vào lãi xuất: ");
                        double laiXuat = new Scanner(System.in).nextDouble();
                        System.out.printf("Nhập vào kỳ hạn gửi(ngày): ");
                        int kyHan = new Scanner(System.in).nextInt();
                        TaiKhoanTietKiem tktk = new TaiKhoanTietKiem(soTaiKhoan, chuTaiKhoan, soDu, matKhau, laiXuat, kyHan);
                        tktk.tienLai(matKhauHT);
                        break;
                    case 6:
                        System.out.println("Mật khẩu hiện tại: "+ tk.getMatKhau());
                        break;
                    case 7:
                        System.out.println("Nhập vào mật khẩu hiện tại: ");
                        String mkht = new Scanner(System.in).nextLine();
                        System.out.println("Nhập vào số tiền cần thanh toán: ");
                        double tienThanhToan = new Scanner(System.in).nextDouble();
                        System.out.println("Nhập vào phí giao dịch: ");
                        double phiGiaoDich = new Scanner(System.in).nextDouble();
                        TaiKhoanThanhToan tktt = new TaiKhoanThanhToan(soTaiKhoan, chuTaiKhoan, soDu, matKhau, phiGiaoDich);
                        tktt.rutTien(tienThanhToan, mkht);
        }
    }while (phuongThuc != 0);
    }
}
