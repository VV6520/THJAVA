import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
        TaiKhoan taiKhoan = new TaiKhoan("0706036827", "LeVietDat", 1000000, "VietDat");
        System.out.println("Chủ tài khoản: " + taiKhoan.getChuTaiKhoan());
        System.out.println("Số tài khoản: " + taiKhoan.getSoTaiKhoan());
        System.out.println("Số dư hiện tại: " + taiKhoan.kiemTraSoDu());

        taiKhoan.guiTien(500000); 

        taiKhoan.rutTien(200000);

        System.out.println("Số dư sau giao dịch: " + taiKhoan.kiemTraSoDu());

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập mật khẩu cũ: ");
        String matKhauCu = scanner.nextLine();
        System.out.print("Nhập mật khẩu mới: ");
        String matKhauMoi = scanner.nextLine();

        taiKhoan.doiMatKhau(matKhauCu, matKhauMoi);
        scanner.close();
    }
}
