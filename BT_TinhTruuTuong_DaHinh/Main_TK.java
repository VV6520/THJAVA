package BT_TinhTruuTuong_DaHinh;

import java.util.ArrayList;
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
            System.out.println("\n== Menu Thao Tác ==\n1. Gửi Tiền\n2. Rút Tiền\n3. Kiểm Tra Số Dư\n4. Mở Tài Khoản Tiết Kiệm\n5. Mở Tài Khoản Thanh Toán\n6. Xem Lịch Sử Giao Dịch\n7. Thoát");
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
                    // Gửi Tiền
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauGui = scanner.nextLine();
                    System.out.print("Nhập số tiền cần gửi: ");
                    double soTienGui = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    taiKhoan.guiTien(soTienGui, matKhauGui);
                    break;

                case 2:
                    // Rút Tiền
                    System.out.print("Nhập số tiền cần rút: ");
                    double soTienRut = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    taiKhoan.rutTien(soTienRut); // Gọi phương thức rút tiền
                    break;

                case 3:
                    // Kiểm Tra Số Dư
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauKiemTra = scanner.nextLine();
                    double soDu = taiKhoan.kiemTraSoDu(matKhauKiemTra);
                    if (soDu >= 0) {
                        System.out.println("Số dư hiện tại: " + soDu);
                    }
                    break;

                case 4:
                    // Mở Tài Khoản Tiết Kiệm
                    moTaiKhoanTietKiem(scanner, taiKhoan);
                    break;

                case 5:
                    // Mở Tài Khoản Thanh Toán
                    moTaiKhoanThanhToan(scanner, taiKhoan);
                    break;

                case 6:
                    // Xem Lịch Sử Giao Dịch
                    taiKhoan.xemLichSuGiaoDich();
                    break;

                case 7:
                    // Thoát
                    System.out.println("Thoát khỏi menu thao tác.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    private static void moTaiKhoanThanhToan(Scanner scanner, TaiKhoan taiKhoan) {
        System.out.print("Nhập số tài khoản để mở tài khoản thanh toán: ");
        String soTaiKhoanThanhToan = scanner.nextLine();
        TaiKhoan tkExist = dsTk.getTaiKhoan(soTaiKhoanThanhToan); // Lấy tài khoản dựa trên số tài khoản

        if (tkExist != null) {
            // Tạo tài khoản thanh toán mới
            TaiKhoanThanhToan tkThanhToan = new TaiKhoanThanhToan();
            tkThanhToan.setSoTaiKhoan(soTaiKhoanThanhToan);

            // Nhập thông tin cho tài khoản thanh toán
            tkThanhToan.thongTinTT(); // Nhập loại thanh toán và phí dịch vụ

            // Thêm tài khoản thanh toán vào danh sách
            dsTk.themTaiKhoanTT(tkThanhToan); 
            // Gọi menu tài khoản thanh toán
            menuTaiKhoanTT(scanner, tkThanhToan); 
        } else {
            System.out.println("Số tài khoản không tồn tại. Không thể mở tài khoản thanh toán.");
        }
    }

    private static void moTaiKhoanTietKiem(Scanner scanner, TaiKhoan taiKhoan) {
        System.out.print("Nhập số tài khoản để mở tài khoản tiết kiệm: ");
        String soTaiKhoanTietKiem = scanner.nextLine();
        TaiKhoan tkExist = dsTk.getTaiKhoan(soTaiKhoanTietKiem); // Lấy tài khoản dựa trên số tài khoản

        if (tkExist != null) {
            // Tạo tài khoản tiết kiệm mới
            TaiKhoanTietKiem tkTietKiem = new TaiKhoanTietKiem();
            tkTietKiem.setSoTaiKhoan(soTaiKhoanTietKiem);
            tkTietKiem.laiSuat(); // Thiết lập lãi suất
            tkTietKiem.thietLapKyHan(); // Thiết lập kỳ hạn

            // Thêm tài khoản tiết kiệm vào danh sách
            dsTk.themTaiKhoanTK(tkTietKiem); 
            // Gọi menu tài khoản tiết kiệm
            menuTaiKhoanTK(scanner, tkTietKiem); 
        } else {
            System.out.println("Số tài khoản không tồn tại. Không thể mở tài khoản tiết kiệm.");
        }
    }
    
    private static void menuTaiKhoanTK(Scanner scanner, TaiKhoanTietKiem tkTietKiem) {
        // Kiểm tra xem tài khoản có hợp lệ hay không
        if (tkTietKiem == null) {
            System.out.println("Tài khoản không hợp lệ.");
            return; // Thoát nếu không có tài khoản
        }

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
                    double lai = tkTietKiem.tinhLai(); // Tính lãi
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
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    if (soTienRut <= 0) {
                        System.out.println("Số tiền rút phải lớn hơn 0.");
                    } else {
                        tkTietKiem.rutTien(soTienRut);
                    }
                    break;
                case 5:
                    // Gửi tiền tiết kiệm
                    System.out.print("Nhập số tiền cần gửi: ");
                    double soTienGui = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    if (soTienGui <= 0) {
                        System.out.println("Số tiền gửi phải lớn hơn 0.");
                    } else {
                        tkTietKiem.guiTien(soTienGui);
                    }
                    break;
                case 6:
                    // Xem thông tin tài khoản
                    tkTietKiem.Xuat(); // Gọi phương thức Xuat để xem thông tin tài khoản
                    break;
                case 7:
                    // Cập nhật lãi suất
                    tkTietKiem.capNhatLaiSuat(scanner); // Gọi phương thức để cập nhật lãi suất
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
    
    private static void menuTaiKhoanTT(Scanner scanner, TaiKhoanThanhToan tkThanhToan) {
        // Kiểm tra xem tài khoản có hợp lệ hay không
        if (tkThanhToan == null) {
            System.out.println("Tài khoản không hợp lệ.");
            return; // Thoát nếu không có tài khoản
        }

        boolean exit = false;

        do {
            System.out.println("\n== Menu Tài Khoản Thanh Toán == ");
            System.out.println("1. Gửi tiền");
            System.out.println("2. Rút tiền");
            System.out.println("3. Chuyển tiền");
            System.out.println("4. Thanh toán phí dịch vụ");
            System.out.println("5. Nạp card");
            System.out.println("6. Thanh toán hóa đơn");
            System.out.println("7. Xem thông tin tài khoản");
            System.out.println("8. Xem lịch sử giao dịch");
            System.out.println("9. Thoát");
            System.out.print("Chọn thao tác: ");

            int choice;
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
                    // Gửi tiền
                    System.out.print("Nhập số tiền cần gửi: ");
                    double soTienGui = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    tkThanhToan.guiTien(soTienGui, tkThanhToan.getMatKhau());
                    break;
                case 2:
                    // Rút tiền
                    System.out.print("Nhập số tiền cần rút: ");
                    double soTienRut = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    tkThanhToan.rutTien(soTienRut, tkThanhToan.getMatKhau());
                    break;
                case 3:
                    // Chuyển tiền
                    System.out.print("Nhập số tiền cần chuyển: ");
                    double soTienChuyen = scanner.nextDouble();
                    scanner.nextLine(); // Đọc bỏ ký tự newline
                    System.out.print("Nhập số tài khoản nhận: ");
                    String soTaiKhoanNhan = scanner.nextLine();
                    tkThanhToan.chuyenTien(soTienChuyen, soTaiKhoanNhan, (ArrayList<TaiKhoan>) dsTk.DanhSachTaiKhoan());
                    break;
                case 4:
                    // Thanh toán phí dịch vụ
                    System.out.print("Nhập phí dịch vụ: ");
                    double phiDichVu = scanner.nextDouble();
                    tkThanhToan.thanhToanPhiDichVu(phiDichVu);
                    break;
                case 5:
                    // Nạp card
                    tkThanhToan.napCard();
                    break;
                case 6:
                    // Thanh toán hóa đơn
                    tkThanhToan.thanhToanHoaDon();
                    break;
                case 7:
                    // Xem thông tin tài khoản
                    tkThanhToan.xemThongTinTaiKhoan();
                    break;
                case 8:
                    // Xem lịch sử giao dịch
                    tkThanhToan.xemLichSuGiaoDich();
                    break;
                case 9:
                    // Thoát
                    exit = true;
                    System.out.println("Đã thoát khỏi menu tài khoản thanh toán.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (!exit);
    }
}