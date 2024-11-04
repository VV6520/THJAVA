package BT_TinhKeThua;

import java.util.Scanner;

public class Main_TK {
    private static DS_TK dsTk = new DS_TK(); // Danh sách tài khoản

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n== Menu Chính ==\n1. Đăng Ký\n2. Đăng Nhập\n3. Quên Mật Khẩu\n4. Xem Danh Sách Tài Khoản\n5. Thoát");
            System.out.print("Chọn thao tác: ");

            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự newline
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.nextLine(); // Đọc bỏ dòng không hợp lệ
                continue;
            }

            switch (choice) {
                case 1:
                    // Đăng Ký
                    dsTk.Nhap(); // Nhập thông tin tài khoản
                    break;

                case 2:
                    // Đăng Nhập
                    System.out.print("Nhập số tài khoản: ");
                    String soTaiKhoanDangNhap = scanner.nextLine();
                    if (dsTk.DangNhap(soTaiKhoanDangNhap)) {
                        System.out.println("Đăng nhập thành công!");
                        // Gọi menu thao tác sau khi đăng nhập
                        menuThaoTac(scanner, soTaiKhoanDangNhap);
                    } else {
                        System.out.println("Đăng nhập thất bại.");
                    }
                    break;

                case 3:
                    // Quên Mật Khẩu
                    dsTk.QuenMatKhau(); // Gọi phương thức QuenMatKhau từ lớp DS_TK
                    break;

                case 4:
                    // Xem Danh Sách Tài Khoản
                    dsTk.Xuat();
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    private static void menuThaoTac(Scanner scanner, String soTaiKhoan) {
        TaiKhoan taiKhoan = dsTk.getTaiKhoan(soTaiKhoan); // Lấy tài khoản
        int choice;
    
        do {
            System.out.println("\n== Menu Thao Tác ==\n1. Gửi Tiền\n2. Rút Tiền\n3. Kiểm Tra Số Dư\n4. Mở Tài Khoản Tiết Kiệm\n5. Xem Lịch Sử Giao Dịch\n6. Thoát");
            System.out.print("Chọn thao tác: ");
    
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự newline
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.nextLine(); // Đọc bỏ dòng không hợp lệ
                continue;
            }
    
            switch (choice) {
                case 1:
                    guiTien(scanner, taiKhoan);
                    break;
    
                case 2:
                    rutTien(scanner, taiKhoan);
                    break;
    
                case 3:
                    kiemTraSoDu(scanner, taiKhoan);
                    break;
    
                case 4:
                    moTaiKhoanTietKiem(scanner, taiKhoan);
                    break;
    
                case 5:
                    taiKhoan.xemLichSuGiaoDich();
                    break;
    
                case 6:
                    System.out.println("Thoát khỏi menu thao tác.");
                    return;
    
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }
    
    private static void moTaiKhoanTietKiem(Scanner scanner, TaiKhoan taiKhoan) {
        System.out.print("Nhập số tài khoản để mở tài khoản tiết kiệm: ");
        String soTaiKhoanTietKiem = scanner.nextLine();
        TaiKhoan tkExist = dsTk.getTaiKhoan(soTaiKhoanTietKiem);
    
        if (tkExist != null) {
            TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem();
            tkTietKiem.setSoTaiKhoan(soTaiKhoanTietKiem);
            tkTietKiem.laiSuat(); // Thiết lập lãi suất
            tkTietKiem.thietLapKyHan(); // Thiết lập kỳ hạn
            dsTk.themTaiKhoan(tkTietKiem); // Thêm tài khoản tiết kiệm vào danh sách
            System.out.println("Đã mở tài khoản tiết kiệm thành công.");
            menuTaiKhoanTK(scanner, soTaiKhoanTietKiem); // Gọi menu tài khoản tiết kiệm
        } else {
            System.out.println("Số tài khoản không tồn tại. Không thể mở tài khoản tiết kiệm.");
        }
    }
    
    private static void menuTaiKhoanTK(Scanner scanner, String soTaiKhoan) {
        TaiKhoan taiKhoan = dsTk.getTaiKhoan(soTaiKhoan); // Lấy tài khoản dựa trên số tài khoản

        // Kiểm tra xem tài khoản có phải là TaiKhoanTietKiem không
        if (!(taiKhoan instanceof TaiKhoanTietKiem)) {
            System.out.println("Tài khoản không phải là tài khoản tiết kiệm.");
            return; // Thoát nếu không phải tài khoản tiết kiệm
        }

        TaiKhoanTietKiem tkTietKiem = (TaiKhoanTietKiem) taiKhoan;
        boolean exit = false;

        do {
            System.out.println("\n== Menu Tài Khoản Tiết Kiệm == ");
            System.out.println("1. Tính lãi");
            System.out.println("2. Rút lãi đúng kỳ hạn");
            System.out.println("3. Rút lãi không kỳ hạn");
            System.out.println("4. Rút tiền");
            System.out.println("5. Gửi tiền tiết kiệm");
            System.out.println("6. Xem thông tin tài khoản");
            System.out.println("7. Cập nhật lãi suất");
            System.out.println("8. Xem lịch sử giao dịch");
            System.out.println("9. Thoát");
            System.out.print("Chọn thao tác: ");

            int choice;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự newline
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.nextLine(); // Đọc bỏ dòng lỗi
                continue;
            }

            switch (choice) {
                case 1:
                    // Tính lãi
                    double lai = tkTietKiem.tinhLai();
                    System.out.println("Số lãi dự kiến: " + lai + " VND");
                    break;
                case 2:
                    // Rút lãi đúng kỳ hạn
                    tkTietKiem.rutLaiDungKyHan(scanner);
                    break;
                case 3:
                    // Rút lãi không kỳ hạn
                    tkTietKiem.rutLaiKhongKyHan(scanner);
                    break;
                case 4:
                    // Rút tiền
                    System.out.print("Nhập số tiền cần rút: ");
                    double soTienRut = scanner.nextDouble();
                    tkTietKiem.rutTien(soTienRut);
                    break;
                case 5:
                    // Gửi tiền tiết kiệm
                    System.out.print("Nhập số tiền cần gửi: ");
                    double soTienGui = scanner.nextDouble();
                    tkTietKiem.guiTien(soTienGui);
                    break;
                case 6:
                    // Xem thông tin tài khoản
                    tkTietKiem.xemThongTinTaiKhoan();
                    break;
                case 7:
                    // Cập nhật lãi suất
                    tkTietKiem.capNhatLaiSuat(scanner);
                    break;
                case 8:
                    // Xem lịch sử giao dịch
                    tkTietKiem.xemLichSuGiaoDich();
                    break;
                case 9:
                    // Thoát
                    exit = true;
                    System.out.println("Đã thoát khỏi menu tài khoản tiết kiệm.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (!exit);
    }
}
    
    