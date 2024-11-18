package BT_TinhTruuTuong_DaHinh;

import java.util.Scanner;
import java.util.InputMismatchException;
public class Main_TK {
    private static DS_TK dsTk = new DS_TK(); // Danh sách tài khoản

    public static void main(String[] args) {
        Menu();
    }

    public static void Menu() {
        Scanner scanner = new Scanner(System.in);        int choice;

        do {
            System.out.println("\n== Menu Chính ==\n1. Đăng Ký\n2. Đăng Nhập\n3. Quên Mật Khẩu\n4. Xem Danh Sách Tài Khoản\n5. Xóa Tài Khoản\n6. Tìm Kiếm Tài Khoản\n7. Thoát");
            System.out.print("Chọn thao tác: ");

            choice = getValidInteger(scanner);

            switch (choice) {
                case 1:
                    dsTk.DangKy(); // Gọi phương thức đăng ký
                    break;

                case 2:
                    String soTaiKhoan = dsTk.DangNhapTK(); // Gọi phương thức đăng nhập và nhận số tài khoản
                    if (soTaiKhoan != null) { // Kiểm tra xem đăng nhập có thành công không
                        menuThaoTac(scanner, soTaiKhoan); // Chuyển sang menu thao tác
                    } else {
                        System.out.println("Đăng nhập không thành công.");
                    }
                    break;

                case 3:
                    dsTk.QuenMatKhau(); // Gọi phương thức quên mật khẩu
                    break;

                case 4:
                    dsTk.hienThiDanhSachTaiKhoan(); // Xem danh sách tài khoản
                    break;

                case 5:
                    System.out.print("Nhập số tài khoản cần xóa: ");
                    String soTaiKhoanXoa = scanner.nextLine();
                    dsTk.xoaTaiKhoan(soTaiKhoanXoa); // Gọi phương thức xóa tài khoản
                    break;

                case 6:
                    System.out.print("Nhập số tài khoản cần tìm: ");
                    String soTaiKhoanTim = scanner.nextLine();
                    TaiKhoan taiKhoanTim = dsTk.getTaiKhoan(soTaiKhoanTim); // Gọi phương thức tìm kiếm
                    if (taiKhoanTim != null) {
                        System.out.println("-------------------------");
                        taiKhoanTim.Xuat(); // Hiển thị thông tin tài khoản
                    } else {
                        System.out.println("Không tìm thấy tài khoản với số tài khoản: " + soTaiKhoanTim);
                    }
                    break;

                case 7:
                    System.out.println("Thoát chương trình."); // Thoát
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }

    private static int getValidInteger(Scanner scanner) {
        while (true) {
            try {
                int value = scanner.nextInt();
                scanner.nextLine(); // Đọc bỏ ký tự newline
                return value;
            } catch (Exception e) {
                System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
                scanner.nextLine(); // Đọc bỏ dòng không hợp lệ
            }
        }
    }

    private static void menuThaoTac(Scanner scanner, String soTaiKhoan) {
        TaiKhoan taiKhoan = dsTk.getTaiKhoan(soTaiKhoan);
        if (taiKhoan == null) {
            System.out.println("Tài khoản không hợp lệ.");
            return;
        }

        int choice;
        do {
            System.out.println("\n== Menu Thao Tác ==\n1. Mở Tiết Kiệm\n2. Thanh Toán\n3. Kiểm Tra Số Dư\n4. Thêm tài khoản mới\n5. Thoát");
            System.out.print("Chọn thao tác: ");

            choice = getValidInteger(scanner);

            switch (choice) {
                case 1:
                    moTaiKhoanTietKiem(scanner, dsTk);
                    break;

                case 2:
                     moTaiKhoanThanhToan(scanner, dsTk);
                    break;

                case 3:
                    System.out.print("Nhập mật khẩu: ");
                    String matKhauKiemTra = scanner.nextLine();
                    double soDu = taiKhoan.kiemTraSoDu(matKhauKiemTra);
                    if (soDu >= 0) {
                        System.out.println("Số dư hiện tại: " + soDu);
                    }
                    break;
                    
                case 4:
                    dsTk.themTaiKhoan(); // Gọi phương thức thêm tài khoản
                    break;

                case 5:
                    System.out.println("Thoát khỏi menu thao tác.");
                    return;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (true);
    }
    
    private static void moTaiKhoanTietKiem(Scanner scanner, DS_TK dsTk) {
        System.out.print("Mời nhập lại số tài khoản để sử dụng: ");
        String soTaiKhoanTietKiem = scanner.nextLine();
        TaiKhoan tkExist = dsTk.getTaiKhoan(soTaiKhoanTietKiem); // Sử dụng phương thức getTaiKhoan từ dsTk

        if (tkExist instanceof TaiKhoanTietKiem taiKhoanTietKiem)
            // Gọi phương thức menuTaiKhoanTK để thực hiện các thao tác với tài khoản tiết kiệm
            menuTaiKhoanTK(scanner, taiKhoanTietKiem);
        else 
            System.out.println("Số tài khoản không tồn tại hoặc không phải là tài khoản tiết kiệm.");
    }

    private static void menuTaiKhoanTK(Scanner scanner, TaiKhoanTietKiem tkTietKiem) {
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

            int choice = getValidInteger(scanner);

            switch (choice) {
                case 1:
                    double lai = tkTietKiem.tinhLai();
                    System.out.println("Số lãi dự kiến: " + lai + " VND");
                    break;
                case 2:
                    tkTietKiem.rutLaiDungKyHan(scanner);
                    break;
                case 3:
                    tkTietKiem.rutLaiKhongKyHan(scanner);
                    break;
                case 4:
                    System.out.print("Nhập số tiền cần rút: ");
                    try {
                        double soTienRut = scanner.nextDouble();
                        scanner.nextLine(); // Đọc bỏ ký tự newline
                        tkTietKiem.rutTien(soTienRut); // Gọi phương thức rút tiền
                    } catch (InputMismatchException e) {
                        System.out.println("Vui lòng nhập vào một số hợp lệ.");
                        scanner.nextLine(); // Đọc bỏ dòng nhập không hợp lệ
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage()); // In ra thông báo lỗi từ ngoại lệ
                    }
                    break;

                case 5:
                    System.out.print("Nhập số tiền cần gửi: ");
                    try {
                        double soTienGui = scanner.nextDouble();
                        scanner.nextLine(); // Đọc bỏ ký tự newline
                        tkTietKiem.guiTien(soTienGui); // Gọi phương thức gửi tiền
                    } catch (InputMismatchException e) {
                        System.out.println("Vui lòng nhập vào một số hợp lệ.");
                        scanner.nextLine(); // Đọc bỏ dòng nhập không hợp lệ
                    }
                    break;
                case 6:
                    tkTietKiem.Xuat(); // Hiển thị thông tin tài khoản
                    break;
                case 7:
                    tkTietKiem.capNhatLaiSuat(scanner);
                    break;
                case 8:
                    tkTietKiem.LichSuGiaoDich(); // Hiển thị lịch sử giao dịch
                    break;
                case 9:
                    exit = true;
                    System.out.println("Đã thoát khỏi menu tài khoản tiết kiệm.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } while (!exit);
    }

    private static void moTaiKhoanThanhToan(Scanner scanner, DS_TK dsTk) {
        System.out.print("Mời nhập lại số tài khoản để sử dụng: ");
        String soTaiKhoanThanhToan = scanner.nextLine();
        TaiKhoan tkExist = dsTk.getTaiKhoan(soTaiKhoanThanhToan); // Sử dụng phương thức getTaiKhoan từ dsTk

        if (tkExist instanceof TaiKhoanThanhToan taiKhoanThanhToan)
            // Gọi phương thức menuTaiKhoanTT để thực hiện các thao tác với tài khoản thanh toán
            menuTaiKhoanTT(scanner, taiKhoanThanhToan);
        else 
            System.out.println("Số tài khoản không tồn tại hoặc không phải là tài khoản thanh toán.");
    }

    private static void menuTaiKhoanTT(Scanner scanner, TaiKhoanThanhToan tkThanhToan) {
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

            int choice = getValidInteger(scanner);

            switch (choice) {
                case 1:
                    
                    System.out.print("Nhập số tiền cần gửi: ");
                    double soTienGui = scanner.nextDouble();
                    scanner.nextLine();
                    tkThanhToan.guiTien(soTienGui);
                    break;
                case 2:
                    System.out.print("Nhập số tiền cần rút: ");
                    double soTienRut = scanner.nextDouble();
                    scanner.nextLine();
                    tkThanhToan.rutTien(soTienRut);
                    break;
                case 3:
                    System.out.print("Nhập số tiền cần chuyển: ");
                    double soTienChuyen = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Nhập số tài khoản nhận: ");
                    String soTaiKhoanNhan = scanner.nextLine();
                    tkThanhToan.chuyenKhoan(soTienChuyen, soTaiKhoanNhan, dsTk);
                    break;
                case 4:
                    System.out.print("Nhập phí dịch vụ: ");
                    double phiDichVu = scanner.nextDouble();
                    scanner.nextLine();
                    tkThanhToan.thanhToanPhiDichVu(phiDichVu, scanner);
                    break;
                case 5:
                    tkThanhToan.napCard();
                    break;
                case 6:
                    tkThanhToan.thanhToanHoaDon();
                    break;
                case 7:
                    tkThanhToan.xemThongTinTaiKhoan();
                    break;
                case 8:
                    tkThanhToan.LichSuGiaoDich();
                    break;
                case 9:
                    exit = true;
                    System.out.println("Đã thoát khỏi menu tài khoản thanh toán.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        } 
        while (!exit);
    }
}