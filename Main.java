package BT_KETHUA;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Tai_Khoan taiKhoan = null;

        System.out.println("Chọn loại tài khoản muốn tạo:");
        System.out.println("1. Tài Khoản Tiết Kiệm");
        System.out.println("2. Tài Khoản Thanh Toán");
        System.out.print("Lựa chọn của bạn: ");
        int loaiTaiKhoan = scanner.nextInt();
        scanner.nextLine(); // Đọc ký tự xuống dòng

        System.out.print("Nhập số tài khoản: ");
        String soTaiKhoan = scanner.nextLine();
        System.out.print("Nhập tên chủ tài khoản: ");
        String chuTaiKhoan = scanner.nextLine();
        System.out.print("Nhập số dư ban đầu: ");
        double soDu = scanner.nextDouble();
        scanner.nextLine(); // Đọc ký tự xuống dòng
        System.out.print("Nhập mật khẩu: ");
        String matKhau = scanner.nextLine();

        if (loaiTaiKhoan == 1) {
            System.out.print("Nhập lãi suất (%): ");
            double laiSuat = scanner.nextDouble();
            System.out.print("Nhập số dư tối thiểu: ");
            double soDuToiThieu = scanner.nextDouble();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            // Tạo tài khoản tiết kiệm
            taiKhoan = new TaiKhoan_TietKiem(soTaiKhoan, chuTaiKhoan, soDu, matKhau, laiSuat, soDuToiThieu);
        } else if (loaiTaiKhoan == 2) {
            // Tạo tài khoản thanh toán
            taiKhoan = new TaiKhoan_ThanhToan(soTaiKhoan, chuTaiKhoan, soDu, matKhau);
        } else {
            System.out.println("Lựa chọn không hợp lệ.");
            return;
        }

        System.out.println("\n-- Thông tin tài khoản --");
        System.out.println("Số tài khoản: " + taiKhoan.getSoTaiKhoan());
        System.out.println("Chủ tài khoản: " + taiKhoan.getChuTaiKhoan());
        System.out.println("Số dư: " + taiKhoan.getSoDu() + " VND");

        while (true) {
            System.out.println("\n== Menu ==");
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Kiểm tra số dư");
            System.out.println("4. Thay đổi mật khẩu");
            if (taiKhoan instanceof TaiKhoan_TietKiem) {
                System.out.println("5. Tính lãi suất (Chỉ áp dụng cho Tài Khoản Tiết Kiệm)");
            }
            System.out.println("0. Thoát");
            System.out.print("Chọn thao tác muốn thực hiện: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc ký tự xuống dòng

            switch (choice) {
                case 1:
                    System.out.print("Nhập số tiền muốn gửi: ");
                    double soTienGui = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauGui = scanner.nextLine();
                    taiKhoan.guiTien(soTienGui, matKhauGui);
                    break;

                case 2:
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauRut = scanner.nextLine();
                    System.out.print("Nhập số tiền muốn rút: ");
                    double soTienRut = scanner.nextDouble();
                    scanner.nextLine(); // Đọc ký tự xuống dòng
                    taiKhoan.rutTien(soTienRut, matKhauRut);
                    break;

                case 3:
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauKiemTra = scanner.nextLine();
                    double soDuHienTai = taiKhoan.kiemTraSoDu(matKhauKiemTra);
                    if (soDuHienTai != -1) {
                        System.out.println("Số dư hiện tại: " + soDuHienTai);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mật khẩu cũ để thay đổi: ");
                    String matKhauCu = scanner.nextLine();
                    if (matKhauCu.equals(taiKhoan.getmatKhau())) {
                        System.out.print("Nhập mật khẩu mới: ");
                        String matKhauMoi = scanner.nextLine();
                        if (taiKhoan.doiMatKhau(matKhauCu, matKhauMoi)) {
                            System.out.println("Đổi mật khẩu thành công.");
                        }
                    } else {
                        System.out.println("Mật khẩu cũ không đúng.");
                    }
                    break;

                case 5:
                    if (taiKhoan instanceof TaiKhoan_TietKiem) {
                        // Tính lãi suất cho tài khoản tiết kiệm
                        ((TaiKhoan_TietKiem) taiKhoan).tinhLai();
                    } else {
                        System.out.println("Lựa chọn không hợp lệ.");
                    }
                    break;

                case 0:
                    System.out.println("Thoát chương trình.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }
    }
}